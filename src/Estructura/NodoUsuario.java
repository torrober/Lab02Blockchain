/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Objetos.Usuario;

/**
 *
 * @author Jaider
 */
public class NodoUsuario extends Nodo {
    Usuario user;


    public NodoUsuario(Usuario user) {
        this.user = user;
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

}
