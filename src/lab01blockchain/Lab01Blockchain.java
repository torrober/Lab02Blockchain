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
import Estructura.Nodo;
import UI.Login;
import Utils.IPDetails;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.JSONObject;
/**
 *
 * @author guest
 */
public class Lab01Blockchain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
            // TODO code application logic here
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Lab01Blockchain.class.getName()).log(Level.SEVERE, null, ex);
        }
            Login m = new Login();
            m.setVisible(true);
            //MainWindow m = new MainWindow("Test");
            //m.setVisible(true);

    }
    
}
