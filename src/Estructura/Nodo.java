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

    Usuario usuario;
    Transaccion transaccion;
    String dato;
    int numHijos;
    Nodo hijos[];
    Nodo hijosAux[];

    public Nodo(String dato) {
      this.dato=dato;
      this.numHijos=0;
    }
    
    public Nodo(Usuario user) {
        this.usuario=user;
        this.numHijos=0;
    }

    public Nodo(Transaccion transaccion) {
        this.transaccion = transaccion;
        this.numHijos = 0;
    }
            
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public void temp() {
        hijosAux = new Nodo[numHijos + 1];
        for (int i = 0; i < this.numHijos; i++) {
            hijosAux[i] = hijos[i];
        }
    }

    public void aumentarHijos(Nodo a) {
        temp();
        hijosAux[this.numHijos] = a;
        hijos = hijosAux;
        this.numHijos++;
    }

}
