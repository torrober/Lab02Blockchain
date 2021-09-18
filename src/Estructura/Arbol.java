/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.Vector;

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

    public void insertarUsuario(Nodo a, String dato, Nodo r) {
        NodoUsuario nuevo = new NodoUsuario(dato);
        if (a == r) {
            a.aumentarHijos(nuevo);
        } else {
            for (int i = 0; i < a.numHijos; i++) {
                if (a.hijos[i] == (r)) {
                    a.hijos[i].aumentarHijos(nuevo);
                } else {
                    insertarUsuario(a.hijos[i], dato, r);
                }
            }
        }
    }

    public void insertarTransaccion(Nodo a, String dato, Nodo r) {
        NodoTransaccion nuevo = new NodoTransaccion(dato);
        if (a == r) {
            if (a.numHijos < 3) {
                a.aumentarHijos(nuevo);
            }
        } else {
            for (int i = 0; i < a.numHijos; i++) {
                if (a.hijos[i] == (r)) {
                    if (a.hijos[i].numHijos > 3) {
                        a.hijos[i].aumentarHijos(nuevo);
                    } else {
                        Nodo bloque = new Nodo();
                        bloque.aumentarHijos(nuevo);
                        a.hijos[i].aumentarHijos(bloque);
                    }
                } else {
                    insertarTransaccion(a.hijos[i], dato, r);
                }
            }
        }
    }

    public void insertarEstado(Nodo a, NodoTransaccion t) {
        NodoEstado antes = new NodoEstado();
        NodoEstado despues = new NodoEstado();
        if (a == t) {
            a.aumentarHijos(antes);
            a.aumentarHijos(despues);
        } else {
            for (int i = 0; i < a.numHijos; i++) {
                if (a.hijos[i] == (t)) {
                    a.hijos[i].aumentarHijos(antes);
                    a.hijos[i].aumentarHijos(despues);
                } else {
                    insertarEstado(a.hijos[i], t);
                }
            } 
        }
    }

    public void recorrido(Nodo raiz) {
        for (int i = 0; i < raiz.numHijos; i++) {
            recorrido(raiz.hijos[i]);
        }
    }
}
