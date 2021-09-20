/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author jeste
 */
public class LeerArchivos {

    public String leerTxt(String direccion) { //direccion del archivo
        String texto = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfread;
            while ((bfread = bf.readLine()) != null) { //se cumple el ciclo mientras bfread tenga datos
                temp = temp + bfread; // guardado el texto del archivo
            }
            texto = temp;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro el archivo");
        }
        return texto;
    }
}
/* como ejemplo puedes poner
LeerArchivos a = new LeerArvhivos();
a.leertxt("destino o lugar donde se encuentra el archivo");
para mostrar lo que tiene el archivo se encierra todo en un system.out.println
 */
