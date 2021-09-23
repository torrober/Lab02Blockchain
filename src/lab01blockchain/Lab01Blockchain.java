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
import static Estructura.Cadena.UTXOs;
import Estructura.Nodo;
import Objetos.Billetera;
import Objetos.SalidasT;
import Objetos.Sexo;
import Objetos.TipoDoc;
import Objetos.Transaccion1;
import Objetos.Usuario;
import UI.Login;
import Utils.FileUtils;
import Utils.IPDetails;
import Utils.StringUtil;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.io.IOException;
import java.security.Security;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author guest
 */
public class Lab01Blockchain {

    public static void main(String[] args) {
        /*Bloque origen = new Bloque("0");
        Billetera A = new Billetera();
        Billetera B = new Billetera();
        Billetera madre = new Billetera();
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        //create genesis transaction, which sends 100 NoobCoin to walletA: 
		Transaccion1 genesisTransaction = new Transaccion1(madre.publicKey, A.publicKey, 100f, null);
		genesisTransaction.generarSignature(madre.privateKey);	 //manually sign the genesis transaction	
		genesisTransaction.idTransaccion = "0"; //manually set the transaction id
		genesisTransaction.outputs.add(new SalidasT(genesisTransaction.remitente, genesisTransaction.monto, genesisTransaction.idTransaccion)); //manually add the Transactions Output
		UTXOs.put(genesisTransaction.outputs.get(0).id, genesisTransaction.outputs.get(0)); //its important to store our first transaction in the UTXOs list.*/
		
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Lab01Blockchain.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login m = new Login();
        m.setVisible(true);
        //Usuario u = new Usuario("torro","aaaa","Roberto", "Rocha","6/22/2002",32534546,TipoDoc.cedCiudadania,Sexo.Masculino);
        //FileUtils.WriteUserToFile(u);
//MainWindow m = new MainWindow("Test");
        //m.setVisible(true);

    }

}
