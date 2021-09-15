/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Objetos.Transaccion;
import Objetos.Usuario;

/**
 *
 * @author usuario
 */
public class Nodo {
    String dato;
    Object info[];
    int numHijos;
    Nodo hijos[];

    public Nodo(String dato) {
        this.dato = dato;
        this.numHijos = 0;
    }

    public Nodo(Object[] info, int numHijos) {
        this.info = info;
        this.numHijos = 0;
    }

    public Object[] getInfo() {
        return info;
    }

    public void setInfo(Object[] info) {
        this.info = info;
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

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo[] temp() {
        Nodo hijosAux[];
        hijosAux = new Nodo[numHijos + 1];
        for (int i = 0; i < this.numHijos; i++) {
            hijosAux[i] = hijos[i];
        }
        return hijosAux;
    }

    public void aumentarHijos(Nodo a) {
        Nodo aux[];
        aux = temp();
        aux[this.numHijos] = a;
        hijos = aux;
        this.numHijos++;
    }

}
