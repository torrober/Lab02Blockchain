/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Objetos.Transaccion1;

/**
 *
 * @author Jaider
 */
public class NodoTransaccion extends Nodo {
    Transaccion1 transaccion;

    public NodoTransaccion(Transaccion1 trans) {
        this.numHijos=0;
        this.transaccion=trans;
    }


    

}
