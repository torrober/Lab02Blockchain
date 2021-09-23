/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Objetos.Billetera;
import Objetos.Transaccion;
import Objetos.Usuario;

/**
 *
 * @author usuario
 */
public class Arbol {

    Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void insertarUsuario(Nodo a, Usuario dato) {
        NodoUsuario nuevo = new NodoUsuario(dato);
        a.hijos[0].aumentarHijos(nuevo);
    }

    public void insertarBloque(Nodo a, Bloque b) {
        NodoBloque block = new NodoBloque(b);
        a.hijos[1].aumentarHijos(block);

    }

    public void insertarTransaccion(Nodo a, Transaccion t, int cont) {
        NodoTransaccion nuevo = new NodoTransaccion(t);
        for (int i = 0; i < a.hijos[2].numHijos; i++) {
            if (a.hijos[1].hijos[i].numHijos < 3) {
                a.hijos[1].hijos[i].aumentarHijos(nuevo);
            } else {
                insertarTransaccion(a.hijos[1].hijos[i], t, cont + 1);
            }
        }
        if (cont == a.hijos[1].numHijos) {
            NodoBloque baux = (NodoBloque) a.hijos[1].hijos[cont];
            Bloque b = new Bloque(baux.block.id);
            insertarBloque(a, b);
            a.hijos[1].hijos[cont + 1].aumentarHijos(nuevo);
        }
    }

    public void insertarEstado(Nodo a, NodoTransaccion t) {
        NodoEstado antes = new NodoEstado();
        antes.setIdRemitente(t.transaccion.remitente);
        antes.setIdDestinatario(t.transaccion.destinatario);
        Billetera d = (Billetera) t.transaccion.destinatario;
        Billetera r = (Billetera) t.transaccion.remitente;
        antes.setBalanceDest(d.getBalance() - t.transaccion.monto);
        antes.setBalanceRem(r.getBalance() + t.transaccion.monto);
        NodoEstado despues = new NodoEstado();
        despues.setIdRemitente(t.transaccion.remitente);
        despues.setIdDestinatario(t.transaccion.destinatario);
        despues.setBalanceDest(d.getBalance() - t.transaccion.monto);
        despues.setBalanceRem(r.getBalance() + t.transaccion.monto);

        for (int i = 0; i < a.hijos[2].numHijos; i++) {
            for (int j = 0; j < a.hijos[2].hijos[i].numHijos; j++) {
                if (a.hijos[1].hijos[i].hijos[j].equals(t)) {
                    a.hijos[1].hijos[i].hijos[j].aumentarHijos(antes);
                    a.hijos[1].hijos[i].hijos[j].aumentarHijos(despues);
                } else {
                    insertarEstado(a.hijos[1].hijos[i].hijos[j], t);
                }
            }
        }
    }

    public void recorrido(Nodo raiz) {
        for (int i = 0; i < raiz.numHijos; i++) {
            recorrido(raiz.hijos[i]);
        }
    }
}
