package Objetos;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Usuario {
    String nombre, apellido,nacimiento,nickname,contraseña,walletID,privateID;
    TipoDoc tipoDoc;
    Sexo sexo;
    int numDoc;
    double saldo;
    ArrayList<Transaccion> misTransacciones;

    public Usuario(String nombre, String apellido, String nacimiento, String nickname, String contraseña, String walletID, String privateID, TipoDoc tipoDoc, Sexo sexo, int numDoc, double saldo, ArrayList<Transaccion> misTransacciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.nickname = nickname;
        this.contraseña = contraseña;
        this.walletID = walletID;
        this.privateID = privateID;
        this.tipoDoc = tipoDoc;
        this.sexo = sexo;
        this.numDoc = numDoc;
        this.saldo = saldo;
        this.misTransacciones = misTransacciones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getNickname() {
        return nickname;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getWalletID() {
        return walletID;
    }

    public String getPrivateID() {
        return privateID;
    }

    public TipoDoc getTipoDoc() {
        return tipoDoc;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public int getNumDoc() {
        return numDoc;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Transaccion> getMisTransacciones() {
        return misTransacciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setWalletID(String walletID) {
        this.walletID = walletID;
    }

    public void setPrivateID(String privateID) {
        this.privateID = privateID;
    }

    public void setTipoDoc(TipoDoc tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setMisTransacciones(ArrayList<Transaccion> misTransacciones) {
        this.misTransacciones = misTransacciones;
    }


    
    
}
