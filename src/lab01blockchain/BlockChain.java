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
import Objetos.Billetera;
import static Objetos.Sexo.Masculino;
import static Objetos.TipoDoc.cedCiudadania;
import Objetos.Transaccion;
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

    public static Billetera walletA;
    public static Billetera walletB;
    public static Transaccion genesisTransaction;
    public static ArrayList<Bloque> cadena = new ArrayList<Bloque>();
    public static int diff = 0;
    public static float minimumTransaction = 0.1f;

    public static void main(String[] args) throws IOException {
        Grafo grafo = new Grafo();
        grafo.addVertice("SwingPay");
        Usuario prueba1 = new Usuario("Prueba1", "1234", "nombre", "apellido", "01/02/1923", 123456, cedCiudadania, Masculino);
        Billetera billeteraprueba1 = prueba1.getBilleteras().get(0);
        billeteraprueba1.setSaldo(100.0);
        Usuario prueba2 = new Usuario("Prueba2", "1234", "nombre", "apellido", "01/02/1924", 123455, cedCiudadania, Masculino);
        System.out.println("Saldo total prueba 1 " +prueba1.getSaldoTotal());
        System.out.println("Saldo total prueba2 " +prueba2.getSaldoTotal());
        //lee los usuarios en el archivo
        String file = readFile("usuarios.json");
        if (file != "") {
            Gson g = new Gson();
            Usuario[] o = g.fromJson(file, Usuario[].class);
            for (Usuario user : o) {
                grafo.addVerticeUsuario(user);
                System.out.println("Grafo añadido");
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
