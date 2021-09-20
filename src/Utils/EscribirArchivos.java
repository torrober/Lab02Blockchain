/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jeste
 */
public class EscribirArchivos {

    public void EscribirTxt(String nombre) {
        File f;
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;
        try {
            f=new File(nombre);
            fw=new FileWriter(f);
            bw=new BufferedWriter(fw);
            pw=new PrintWriter(bw);
            
            pw.write("esa es nuestra primer linea de codigo"); //aqui se pone la info que queremos guardar en el archivo
            pw.append("\n Esta es nuestra segunda linea de codigo");
            pw.append("\n Linea Final");
            
            pw.close(); //cerramos el archivo
            bw.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ha ocurrido un error");
        }
    }
}
/*
para hacer el llamado usamos
EscribirTxt et=new EscribirTxt();
et.Escribir("nombre del archivo");
Aqui se crea el archivo y el archivo va a guardar la info que este en el apasrtado de pw.write
*/
