/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 *
 * @author guest
 */
public class Arista {

    Vertice inicio, fin;
    int x1, x2, y1, y2, peso;

    public Arista(Vertice inicio, Vertice fin, int peso) {
        this.inicio = inicio;
        this.fin = fin;
        inicio.addVecino(fin);
        fin.addVecino(inicio);
        /*this.x1 = inicio.x;
        this.y1 = inicio.y - 25;
        this.x2 = fin.x;
        this.y2 = fin.y - 25;*/
        this.peso = peso;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public Vertice getFin() {
        return fin;
    }

    public void setFin(Vertice fin) {
        this.fin = fin;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
}
