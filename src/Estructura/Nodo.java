/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 *
 * @author usuario
 */
public class Nodo {

    int numHijos;
    Nodo hijos[];

    public Nodo() {
        this.numHijos = 0;
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
