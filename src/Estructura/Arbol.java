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
public class Arbol {

    Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void insertarhijo(Nodo a, String dato, String r) {
        Nodo nuevo = new Nodo(dato);
        if (a.getDato().equals(r)) {
            a.aumentarHijos(nuevo);
        } else {
            for (int i = 0; i < a.numHijos; i++) {
                if (a.hijos[i].getDato().equals(r)) {
                    a.hijos[i].aumentarHijos(nuevo);
                } else {
                    insertarhijo(a.hijos[i], dato, r);
                }
            }
        }

    }

    public void recorrido(Nodo raiz) {
        for (int i = 0; i < raiz.numHijos; i++) {
            System.out.println(raiz.hijos[i].getDato()+ " ");
            recorrido(raiz.hijos[i]);
        }
    }

}
