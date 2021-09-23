/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Objetos.Transaccion;

/**
 *
 * @author Jaider
 */
public class NodoTransaccion extends Nodo {
    Transaccion transaccion;

    public NodoTransaccion(Transaccion trans) {
        this.numHijos=0;
        this.transaccion=trans;
    }


    

}
