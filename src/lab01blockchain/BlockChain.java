/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01blockchain;

import org.bouncycastle.*;
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
import Objetos.Sexo;
import static Objetos.Sexo.Masculino;
import Objetos.TipoDoc;
import static Objetos.TipoDoc.cedCiudadania;
import Objetos.Transaccion;
import Objetos.Usuario;
import UI.Login;
import Utils.FileUtils;
import static Utils.FileUtils.readFile;
import Utils.IPDetails;
import Utils.StringUtil;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.google.gson.Gson;
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
    public static int diff = 0;
    public static float minimumTransaction = 0.1f;

    public static void main(String[] args) throws IOException {
        Arbol a = new Arbol();
        Nodo raiz = new Nodo();
        Nodo usuarios = new Nodo();
        Nodo bloques = new Nodo();
        a.setRaiz(raiz);
        raiz.aumentarHijos(usuarios);
        raiz.aumentarHijos(bloques);
        Usuario prueba1 = new Usuario("Prueba1", "1234", "nombre", "apellido", "01/02/1923", 123456, cedCiudadania, Masculino);
        prueba1.getBilletera().setSaldo(100);
        Usuario prueba2 = new Usuario("Prueba2", "1234", "nombre", "apellido", "01/02/1924", 123455, cedCiudadania, Masculino);
        System.out.println(prueba1.getNickname());
        System.out.println(prueba1.getContraseña());
        System.out.println(prueba2.getNickname());
        System.out.println(prueba2.getContraseña());
        System.out.println(prueba2.getBilletera().getId());
        System.out.println(prueba1.getBilletera().saldo);
        System.out.println(prueba1.getBilletera().getSaldo());
        //lee los usuarios en el archivo
        String file = readFile("usuarios.json");
        if (file != "") {
            Gson g = new Gson();
            Usuario[] o = g.fromJson(file, Usuario[].class);
            for (Usuario user : o) {
                a.insertarUsuario(raiz, user);
            }
        }
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BlockChain.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login m = new Login();
        m.setVisible(true);
        //TestFrame t = new TestFrame();
        //t.setVisible(true);
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }
}
