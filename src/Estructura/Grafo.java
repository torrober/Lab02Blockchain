/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author guest
 */
public class Grafo {

    ArrayList<Arista> aristas;
    ArrayList<Vertice> vertices;
    int[][] distancia;
    String dfs;

    public Grafo() {
        aristas = new ArrayList();
        vertices = new ArrayList();
    }

    public Grafo(ArrayList<Arista> aristas, ArrayList<Vertice> vertices) {
        this.aristas = aristas;
        this.vertices = vertices;
    }

    public void addVertice(String info, int x, int y) {
        vertices.add(new Vertice(info, x, y));
    }

    public void addArista(Vertice inicio, Vertice fin, int peso) {
        Arista InicioFin = getArista(inicio, fin);
        Arista FinInicio = getArista(fin, inicio);
        int confirmado = JOptionPane.YES_NO_OPTION;
        if (InicioFin == null && FinInicio == null) {
            aristas.add(new Arista(inicio, fin, peso));
        } else {
            if (JOptionPane.showConfirmDialog(null, "Ya existe una arista entre estos nodos, desea reemplazar su valor?", "WARNING", confirmado) == JOptionPane.YES_OPTION) {
                if (InicioFin != null) {
                    InicioFin.peso = peso;
                } else if (FinInicio != null) {
                    FinInicio.peso = peso;
                }
            }
        }
    }

    public Vertice getVertice(String nombre) {
        for (Vertice v : vertices) {
            if (v.nombre.equals(nombre)) {
                return v;
            }
        }
        return null;
    }

    public Arista getArista(Vertice inicio, Vertice fin) {
        for (Arista a : aristas) {
            if (a.inicio == inicio && a.fin == fin) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Arista> getAristas(Vertice v) {
        ArrayList adyacentes = new ArrayList();
        for (Arista a : aristas) {
            if (a.inicio == v || a.fin == v) {
                adyacentes.add(a);
            }
        }
        return adyacentes;
    }
}
