/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;
import java.security.*;
/**
 *
 * @author Jaider
 */
public class NodoEstado extends Nodo {
    PublicKey idRemitente,idDestinatario;
    float balanceRem,balanceDest;

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

    public double getBalanceRem() {
        return balanceRem;
    }

    public void setBalanceRem(float balanceRem) {
        this.balanceRem = balanceRem;
    }

    public double getBalanceDest() {
        return balanceDest;
    }

    public void setBalanceDest(float balanceDest) {
        this.balanceDest = balanceDest;
    }

    public PublicKey getIdRemitente() {
        return idRemitente;
    }

    public void setIdRemitente(PublicKey idRemitente) {
        this.idRemitente = idRemitente;
    }

    public PublicKey getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(PublicKey idDestinatario) {
        this.idDestinatario = idDestinatario;
    }
    



}
