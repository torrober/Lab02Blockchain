/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Objetos.Usuario;
import java.util.ArrayList;

/**
 *
 * @author guest
 */
public class Vertice {

    String nombre;
    Bloque b;
    Usuario u;
    ArrayList<Vertice> vecinos;
    int x, y;
    boolean visitado;
    int distancia;

    public Vertice(String nombre) {
        this.nombre = nombre;
        vecinos = new ArrayList();
    }

    public Vertice(Usuario u) {
        this.u = u;
        vecinos = new ArrayList();
    }

    public Vertice(Bloque b) {
        this.b = b;
        vecinos = new ArrayList();
    }
    
    
    
    public void addVecino(Vertice vecino) {
        vecinos.add(vecino);
    }

    public Bloque getBloque() {
        return b;
    }

    public Usuario getUsuario() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public void setB(Bloque b) {
        this.b = b;
    }
    
    
}
