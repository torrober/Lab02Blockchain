/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01blockchain;

import ComponentesUI.JTestFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Estructura.Arbol;
import Estructura.Nodo;
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
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lab01Blockchain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Lab01Blockchain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Lab01Blockchain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Lab01Blockchain.class.getName()).log(Level.SEVERE, null, ex);
        }
        Arbol a = new Arbol();
        a.setRaiz(new Nodo("0"));
        Nodo n = a.getRaiz();
        a.insertarhijo(n, "1", "0");
        a.insertarhijo(n, "2", "0");
        a.insertarhijo(n, "3", "0");
        
        a.insertarhijo(n, "1.1", "1");
        a.insertarhijo(n, "1.2", "1");
        
        a.insertarhijo(n, "2.1", "2");
        a.insertarhijo(n, "2.2", "2");
        
        a.recorrido(a.getRaiz());
    }
    
}
