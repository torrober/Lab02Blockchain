/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Cuenta {
    String walletID, privateID;
    double saldo;
    Usuario dueño;
    ArrayList<Transaccion> misTransacciones;

    public Cuenta(String walletID, String privateID, Usuario dueño) {
        this.walletID = walletID;
        this.privateID = privateID;
        this.dueño = dueño;
    }

    public String getWalletID() {
        return walletID;
    }

    public void setWalletID(String walletID) {
        this.walletID = walletID;
    }

    public String getPrivateID() {
        return privateID;
    }

    public void setPrivateID(String privateID) {
        this.privateID = privateID;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getDueño() {
        return dueño;
    }

    public void setDueño(Usuario dueño) {
        this.dueño = dueño;
    }
    
    
}
