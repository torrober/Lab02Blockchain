/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 *
 * @author Jaider
 */
public class NodoEstado extends Nodo {
    String idRemitente,idDestinatario;
    double balanceRem,balanceDest;

    public NodoEstado() {
        this.numHijos=0;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public Nodo[] getHijos() {
        return hijos;
    }

    public void setHijos(Nodo[] hijos) {
        this.hijos = hijos;
    }

    public String getIdRemitente() {
        return idRemitente;
    }

    public void setIdRemitente(String idRemitente) {
        this.idRemitente = idRemitente;
    }

    public String getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(String idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public double getBalanceRem() {
        return balanceRem;
    }

    public void setBalanceRem(double balanceRem) {
        this.balanceRem = balanceRem;
    }

    public double getBalanceDest() {
        return balanceDest;
    }

    public void setBalanceDest(double balanceDest) {
        this.balanceDest = balanceDest;
    }
    



}
