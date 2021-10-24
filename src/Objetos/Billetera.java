/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Utils.FileUtils;
import Utils.StringUtil;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaider
 */
public class Billetera {

    public String id = "";
    public double saldo = 0;

    public Billetera(Usuario r) {
        //solo necesitamos un id.. si el usuario tiene solo una billetera, si no, se asigna un string de caracteres aleatorios + fecha de nacimiento
        System.out.println("Billeteras del usuario: " + r.getBilleterasLength());
        if (r.getBilleterasLength() == 0) {
            id = r.numDoc + r.nacimiento.split("/")[2];
            this.id = StringUtil.applySha256(id);
            System.out.println(this.id);
        } else {
            byte[] array = new byte[7]; 
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));
            System.out.println(generatedString);
            id = generatedString + r.nacimiento.split("/")[2];
            this.id = StringUtil.applySha256(id);
        }
    }

    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        try {
            //cambiar saldo en el archivo
            Usuario temp = null;
            String users = FileUtils.readFile("usuarios.json");
            Gson g = new Gson();
            Usuario[] usuarios = g.fromJson(users, Usuario[].class);
            for (Usuario u : usuarios) {
                for (Billetera b : u.getBilleteras()) {
                    if (b.id.equals(this.id)) {
                        b.saldo = saldo;
                    }
                }
            }
            FileUtils.overwriteFile("usuarios.json", g.toJson(usuarios));
            this.saldo = saldo;
        } catch (IOException ex) {
            Logger.getLogger(Billetera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
