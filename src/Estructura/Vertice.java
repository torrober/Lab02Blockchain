/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.ArrayList;

/**
 *
 * @author guest
 */
public class Vertice {

    String nombre;
    ArrayList<Vertice> vecinos;
    int x, y;
    boolean visitado;
    int distancia;

    public Vertice(String nombre, int x, int y) {
        this.nombre = nombre;
        vecinos = new ArrayList();
        this.x = x;
        this.y = y;
    }

    public void addVecino(Vertice vecino) {
        vecinos.add(vecino);
    }
}
