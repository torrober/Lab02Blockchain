/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Objetos.Transaccion;
import Objetos.Usuario;
import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jeste
 */
public class FileUtils {

    public static boolean WriteUserToFile(Usuario u) {
        String usuariofinal = "";
        String nombre = "usuarios.json";
        boolean success = false;
        if (!"".equals(readFile(nombre))) {
            ArrayList<Usuario> usuarios = new ArrayList();
            Gson g = new Gson();     
            String file = readFile(nombre);
            System.out.println(file);
            Usuario[] o = g.fromJson(file, Usuario[].class);
            for (Usuario user : o) {
                usuarios.add(user);
            }
            usuarios.add(u);
            usuariofinal = g.toJson(usuarios);
        } else {
            Gson g = new Gson();
            Usuario[] firstUser = new Usuario[1];
            firstUser[0] = u;
            usuariofinal = g.toJson(firstUser);
        }
        try {
            System.out.println(usuariofinal);
            overwriteFile(nombre, usuariofinal);
            success = true;
        } catch (IOException e) {
            System.out.println(e);
        }
        return success;
    }
    
        public static boolean WriteTransactionToFile(Transaccion t) {
        String transaccionfinal = "";
        String nombre = "transacciones.json";
        boolean success = false;
        if (!"".equals(readFile(nombre))) {
            ArrayList<Transaccion> transacc = new ArrayList();
            Gson g = new Gson();     
            String file = readFile(nombre);
            System.out.println(file);
            Transaccion[] o = g.fromJson(file, Transaccion[].class);
            for (Transaccion tr : o) {
                transacc.add(tr);
            }
            transacc.add(t);
            transaccionfinal = g.toJson(transacc);
        } else {
            Gson g = new Gson();
            Transaccion[] firstTransaction = new Transaccion[1];
            firstTransaction[0] = t;
            transaccionfinal = g.toJson(firstTransaction);
        }
        try {
            overwriteFile(nombre,transaccionfinal );
            success = true;
        } catch (Exception e) {

        }
        return success;
    }

    public static void overwriteFile(String route, String string) throws IOException {
        File f;
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;
        f = new File(".");
        String loc = f.getCanonicalPath() + File.separator + route;
        fw = new FileWriter(loc);
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);
        pw.write(string);
        pw.close(); //cerramos el archivo
        bw.close();
    }
    public static void writeFile(String route, String string) throws IOException{
        File f;
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;
        f = new File(".");
        String loc = f.getCanonicalPath() + File.separator + route;
        fw = new FileWriter(loc, true);
        bw = new BufferedWriter(fw);
        bw.write(string);
        bw.newLine();
        bw.close();        
    }
    public static String readFile(String direccion) { //direccion del archivo
        String texto = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfread;
            while ((bfread = bf.readLine()) != null) {
                temp = temp + bfread;
            }
            texto = temp;
        } catch (FileNotFoundException e) {
            texto = "";
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return texto;
    }
}
