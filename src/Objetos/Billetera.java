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
        //solo necesitamos un id
        id = r.numDoc + r.nacimiento.split("/")[2]; 
        System.out.println(r.numDoc + r.nacimiento.split("/")[2]);
        this.id = StringUtil.applySha256(id);
        //el id esta en sha256, pero nomas pa que parezca que es uno complejo xd
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
                if (u.getBilletera().id.equals(id)) {
                    temp = u;
                    u.getBilletera().saldo = saldo;
                }
            }
            FileUtils.overwriteFile("usuarios.json", g.toJson(usuarios));
            this.saldo = saldo;
        } catch (IOException ex) {
            Logger.getLogger(Billetera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
