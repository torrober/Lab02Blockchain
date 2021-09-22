/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.ArrayList;
import java.util.HashMap;
import Objetos.SalidasT;

/**
 *
 * @author Jaider
 */
public class Cadena {

    public static ArrayList<Bloque> cadena = new ArrayList<Bloque>();
    public static int diff = 4;
    public static HashMap<String, SalidasT> UTXOs = new HashMap<String, SalidasT>();
    public static float minimumTransaction = 0.1f;

    public static Boolean verificarCadena() {
        Bloque actual;
        Bloque anterior;
        String idObjetivo = new String(new char[diff]).replace('\0', '0');
        for (int i = 1; i < cadena.size(); i++) {
            actual = cadena.get(i);
            anterior = cadena.get(i - 1);
            if (!actual.id.equals(actual.generarId())) {
                return false;
            }
            if (!anterior.id.equals(actual.idAntes)) {
                return false;
            }
            if (!actual.id.substring(0, diff).equals(idObjetivo)) {
                return false;
            }
        }
        return true;
    }
}
