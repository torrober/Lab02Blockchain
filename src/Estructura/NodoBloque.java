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
public class NodoBloque extends Nodo{
    Bloque block;

    public NodoBloque(Bloque block) {
        this.numHijos=0;
        this.block = block;
    }
    
}
