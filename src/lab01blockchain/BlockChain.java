/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01blockchain;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Estructura.Bloque;
import Estructura.Grafo;
import Estructura.Vertice;
import Objetos.Billetera;
import static Objetos.Sexo.Masculino;
import static Objetos.TipoDoc.cedCiudadania;
import Objetos.Usuario;
import UI.Login;
import static Utils.FileUtils.readFile;
import com.formdev.flatlaf.FlatLightLaf;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author guest
 */
public class BlockChain {

    public static ArrayList<Bloque> cadena = new ArrayList<Bloque>();

    public static void main(String[] args) throws IOException {
        Grafo grafo = new Grafo();
        grafo.addVertice("SwingPay");
        //lee los usuarios en el archivo
        String file = readFile("usuarios.json");
        if (file != "") {
            Gson g = new Gson();
            Usuario[] o = g.fromJson(file, Usuario[].class);
            for (Usuario user : o) {
                try {
                    Vertice ant = grafo.getVerticeFromUsuario(grafo.getLastUsuario());
                    grafo.addVerticeUsuario(user);
                    Vertice desp = grafo.getVerticeFromUsuario(user);
                    grafo.addArista(ant, desp, 0);
                    System.out.println("Grafo añadido");
                } catch (NullPointerException ex) {
                    Vertice ant = grafo.getVertice("SwingPay");
                    System.out.println("1er grafo");
                    grafo.addVerticeUsuario(user);
                    Vertice desp = grafo.getVerticeFromUsuario(user);
                    grafo.addArista(ant, desp, 0);
                    System.out.println("Grafo añadido");
                    
                }

            }
        }
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BlockChain.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login m = new Login(grafo);
        m.setVisible(true);
        //TestFrame t = new TestFrame();
        //t.setVisible(true);
    }
}
