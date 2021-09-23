/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01blockchain;

import ComponentesUI.TestFrame;
import UI.MainWindow;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Estructura.Arbol;
import Estructura.Bloque;
import Estructura.Nodo;
import Objetos.Billetera;
import Objetos.EntradasT;
import Objetos.SalidasT;
import Objetos.Sexo;
import Objetos.TipoDoc;
import Objetos.Transaccion;
import Objetos.Usuario;
import UI.Login;
import Utils.FileUtils;
import Utils.IPDetails;
import Utils.StringUtil;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.io.IOException;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author guest
 */
public class BlockChain {

    public static Billetera walletA;
    public static Billetera walletB;
    public static Transaccion genesisTransaction;
    public static ArrayList<Bloque> cadena = new ArrayList<Bloque>();
    public static int diff = 4;
    public static HashMap<String, SalidasT> UTXOs = new HashMap<String, SalidasT>();
    public static float minimumTransaction = 0.1f;

    public static void main(String[] args) throws IOException {
        Arbol a = new Arbol();
        Nodo raiz = new Nodo();
        Nodo usuarios = new Nodo();
        Nodo bloques = new Nodo();
        a.setRaiz(raiz);
        raiz.aumentarHijos(usuarios);
        raiz.aumentarHijos(bloques);

        Bloque origen = new Bloque("0");
        Billetera A = new Billetera();
        Billetera B = new Billetera();
        Billetera madre = new Billetera();
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        //create genesis transaction, which sends 100 NoobCoin to walletA: 
        Transaccion genesisTransaction = new Transaccion(madre.publicKey, A.publicKey, 100f, null);
        genesisTransaction.generarSignature(madre.privateKey);	 //manually sign the genesis transaction	
        genesisTransaction.idTransaccion = "0"; //manually set the transaction id
        genesisTransaction.outputs.add(new SalidasT(genesisTransaction.remitente, genesisTransaction.monto, genesisTransaction.idTransaccion)); //manually add the Transactions Output
        UTXOs.put(genesisTransaction.outputs.get(0).id, genesisTransaction.outputs.get(0)); //its important to store our first transaction in the UTXOs list.
        Bloque genesis = new Bloque("0");
        genesis.addTransaccion(genesisTransaction);
        addBlock(genesis);

        try {
            // TODO code application logic here
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BlockChain.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login m = new Login();
        m.setVisible(true);
        //Usuario u = new Usuario("torro","aaaa","Roberto", "Rocha","6/22/2002",32534546,TipoDoc.cedCiudadania,Sexo.Masculino);
        //FileUtils.WriteUserToFile(u);
//MainWindow m = new MainWindow("Test");
        //m.setVisible(true);

    }

    public static Boolean isChainValid() {
        Bloque actual;
        Bloque anterior;
        String hashTarget = new String(new char[diff]).replace('\0', '0');
        HashMap<String, SalidasT> tempUTXOs = new HashMap<String, SalidasT>();
        tempUTXOs.put(genesisTransaction.outputs.get(0).id, genesisTransaction.outputs.get(0));

        for (int i = 1; i < cadena.size(); i++) {
            actual = cadena.get(i);
            anterior = cadena.get(i - 1);
            if (!actual.id.equals(actual.generarId())) {
                return false;
            }
            if (!anterior.id.equals(actual.idAntes)) {
                return false;
            }
            if (!actual.id.substring(0, diff).equals(hashTarget)) {
                return false;
            }
            SalidasT tempOutput;
            for (int t = 0; t < actual.transactions.size(); t++) {
                Transaccion currentTransaction = actual.transactions.get(t);

                if (!currentTransaction.validarSignature()) {
                    return false;
                }
                if (currentTransaction.getvalorEntradas() != currentTransaction.getvalorSalidas()) {
                    return false;
                }

                for (EntradasT input : currentTransaction.inputs) {
                    tempOutput = tempUTXOs.get(input.idSalida);

                    if (tempOutput == null) {
                        return false;
                    }

                    if (input.UTXO.total != tempOutput.total) {
                        return false;
                    }

                    tempUTXOs.remove(input.idSalida);
                }

                for (SalidasT output : currentTransaction.outputs) {
                    tempUTXOs.put(output.id, output);
                }

                if (currentTransaction.outputs.get(0).destinatario != currentTransaction.destinatario) {
                    return false;
                }
                if (currentTransaction.outputs.get(1).destinatario != currentTransaction.remitente) {
                    return false;
                }

            }
        }
        return true;
    }

    public static void addBlock(Bloque newBlock) {
        newBlock.minarbloque(diff);
        cadena.add(newBlock);
    }
}
