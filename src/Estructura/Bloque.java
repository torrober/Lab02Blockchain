/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Objetos.Transaccion;
import Utils.FileUtils;
import Utils.StringUtil;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jaider
 */
public class Bloque {

    public String id;
    public String idAntes;
    public ArrayList<Transaccion> transactions = new ArrayList<Transaccion>();
    public long timeStamp;

    public Bloque(String antes) {
        this.idAntes = antes;
        this.timeStamp = new Date().getTime();
        this.id = generarId();
    }

    public String generarId() {
        String gId = StringUtil.applySha256(
                idAntes
                + Long.toString(timeStamp)
        );
        return gId;
    }

    public boolean addTransaction(Transaccion transaction) {
        if (this.transactions.size() < 2) {
            this.transactions.add(transaction);
            return true;
        } else {
            return false;
        }
    }

    public static void overwriteTransaction(Bloque bl) throws IOException {
        Bloque temp = null;
        String users = FileUtils.readFile("bloques.json");
        System.out.println(users);
        Gson g = new Gson();
        int pos = 0;
        int j = 0;
        Bloque[] bloques = g.fromJson(users, Bloque[].class);
        ArrayList<Bloque> newBloques = new ArrayList();
        for (Bloque b : bloques) {
            if (b.id.equals(bl.id)) {
                newBloques.add(bl);
            } else {
                newBloques.add(b);
            }
        }
        FileUtils.overwriteFile("bloques.json", g.toJson(newBloques));
    }
}
