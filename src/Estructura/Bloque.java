/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Objetos.Transaccion;
import Utils.StringUtil;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jaider
 */
public class Bloque {

    public String id;
    public String idAntes;
    public ArrayList<Transaccion> transactions = new ArrayList<Transaccion>();
    public long timeStamp;

    public Bloque(String antes) {
        this.idAntes = antes;
        this.timeStamp = new Date().getTime();
        this.id = generarId();
    }

    public String generarId() {
        String gId = StringUtil.applySha256(
                idAntes
                + Long.toString(timeStamp)
        );
        return gId;
    }

}
