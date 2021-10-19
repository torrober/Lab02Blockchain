/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Objetos.Transaccion;
import java.security.MessageDigest;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import org.bouncycastle.asn1.sec.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;

/**
 *
 * @author Jaider
 */
public class StringUtil {

    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //Applies sha256 to our input, 
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] applyECDSASig(String privateKey, String input) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException {
       byte[] byte_privkey = Base64.getDecoder().decode(privateKey);
       KeyFactory factory = KeyFactory.getInstance("ECDSA", "BC");
     PrivateKey private_key = (PrivateKey) (ECPrivateKey) factory.generatePublic(new X509EncodedKeySpec(byte_privkey));
        Signature dsa;
        byte[] output = new byte[0];
        try {
            dsa = Signature.getInstance("ECDSA", "BC");
            dsa.initSign(private_key);
            byte[] strByte = input.getBytes();
            dsa.update(strByte);
            byte[] realSig = dsa.sign();
            output = realSig;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    //Verifies a String signature 
    public static boolean verifyECDSASig(String publicKey, String data, byte[] signature) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException {
     byte[] byte_pubkey = Base64.getDecoder().decode(publicKey);
     KeyFactory factory = KeyFactory.getInstance("ECDSA", "BC");
     PublicKey public_key = (ECPublicKey) factory.generatePublic(new X509EncodedKeySpec(byte_pubkey));
        try {
            Signature ecdsaVerify = Signature.getInstance("ECDSA", "BC");
            ecdsaVerify.initVerify(public_key);
            ecdsaVerify.update(data.getBytes());
            return ecdsaVerify.verify(signature);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getStringFromKey(Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public static String getMerkleRoot(ArrayList<Transaccion> transactions) {
        int count = transactions.size();
        ArrayList<String> previousTreeLayer = new ArrayList<String>();
        for (Transaccion transaction : transactions) {
            previousTreeLayer.add(transaction.idTransaccion);
        }
        ArrayList<String> treeLayer = previousTreeLayer;
        while (count > 1) {
            treeLayer = new ArrayList<String>();
            for (int i = 1; i < previousTreeLayer.size(); i++) {
                treeLayer.add(applySha256(previousTreeLayer.get(i - 1) + previousTreeLayer.get(i)));
            }
            count = treeLayer.size();
            previousTreeLayer = treeLayer;
        }
        String merkleRoot = (treeLayer.size() == 1) ? treeLayer.get(0) : "";
        return merkleRoot;
    }
}
