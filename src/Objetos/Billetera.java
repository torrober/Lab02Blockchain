/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.IOException;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lab01blockchain.BlockChain;

/**
 *
 * @author Jaider
 */
public class Billetera {

    public PrivateKey privateKey;
    public PublicKey publicKey;
    public HashMap<String, SalidasT> UTXOs = new HashMap<String, SalidasT>();

    public Billetera() {
        generateKeyPair();
    }

    public void generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            keyGen.initialize(ecSpec, random);
            KeyPair keyPair = keyGen.generateKeyPair();
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //returns balance and stores the UTXO's owned by this wallet in this.UTXOs
    public float getBalance() {
        float total = 0;
        for (Map.Entry<String, SalidasT> item : BlockChain.UTXOs.entrySet()) {
            SalidasT UTXO = item.getValue();
            if (UTXO.verificarMoneda(publicKey)) { //if output belongs to me ( if coins belong to me )
                UTXOs.put(UTXO.id, UTXO); //add it to our list of unspent transactions.
                total += UTXO.total;
            }
        }
        return total;
    }

    public Transaccion sendFunds(PublicKey destinatario, float monto) throws IOException {
        if (getBalance() < monto) { 
            return null;
        }
       ArrayList<EntradasT> inputs = new ArrayList<EntradasT>();
    
		float total = 0;
		for (Map.Entry<String, SalidasT> item: UTXOs.entrySet()){
			SalidasT UTXO = item.getValue();
			total += UTXO.total;
			inputs.add(new EntradasT(UTXO.id));
			if(total > monto) break;
		}
		
		Transaccion nueva = new Transaccion(publicKey, destinatario , monto, inputs);
		nueva.generarSignature(privateKey);
		
		for(EntradasT input: inputs){
			UTXOs.remove(input.idSalida);
		}
		return nueva;
	}
    }
