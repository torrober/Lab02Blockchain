package Estructura;

import Objetos.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author guest
 */
public class Grafo {

    ArrayList<Arista> aristas;
    ArrayList<Vertice> vertices;
    ArrayList<Bloque> bloquesAux;
    ArrayList<Usuario> usuariosAux;

    public Grafo() {
        aristas = new ArrayList();
        vertices = new ArrayList();
        bloquesAux = new ArrayList();
        usuariosAux = new ArrayList();
    }

    public Grafo(ArrayList<Arista> aristas, ArrayList<Vertice> vertices) {
        this.aristas = aristas;
        this.vertices = vertices;
    }

    public void addVertice(String info) {
        vertices.add(new Vertice(info));
    }

    public void addVerticeUsuario(Usuario info) {
        vertices.add(new Vertice(info));
        usuariosAux.add(info);
    }

    public void addVerticeBloque(Bloque info) {
        vertices.add(new Vertice(info));
        bloquesAux.add(info);
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

    public Vertice getVerticeFromUsuario(Usuario u) {
        for (Vertice v : vertices) {
            if (v.getUsuario() != null) {
                if (v.getUsuario().getNickname().equals(u.getNickname())) {
                    return v;
                }
            }
        }
        return null;
    }

    public Vertice getVerticeFromBloque(Bloque b) {
        for (Vertice v : vertices) {
            if (v.getBloque() != null) {
                if (v.getBloque().equals(b.id)) {
                    return v;
                }
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

    public Bloque getUltimoBloque() {
        if (bloquesAux.size() == 0) {
            return null;
        } else {
            int ultimoElemPos = bloquesAux.size() - 1;
            return bloquesAux.get(ultimoElemPos);
        }
    }

    public Usuario getLastUsuario() {
        if (usuariosAux.size() == 0) {
            return null;
        } else {
            int ultimoElemPos = usuariosAux.size() - 1;
            return usuariosAux.get(ultimoElemPos);
        }
    }
}
