/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Utils.StringUtil;

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

    public float getBalance() {
        float total = 0;
        return total;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
