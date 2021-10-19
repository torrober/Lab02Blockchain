/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Utils.FileUtils;
import Utils.StringUtil;
import java.security.*;
import java.util.ArrayList;
import org.json.JSONObject;
import Utils.IPDetails;
import java.io.IOException;
import java.security.spec.InvalidKeySpecException;
import lab01blockchain.BlockChain;

/**
 *
 * @author Jaider
 */
public class Transaccion {

    public String idTransaccion,ip, lugar;
    public String remitente;
    public String destinatario;
    public float monto;
    public double latitud, longitud;
    public long timestamp;
    private static int secuencia = 0;

    public Transaccion(String from, String to, float value) throws IOException {
        this.remitente = from;
        this.destinatario = to;
        this.monto = value;
        String ipData = IPDetails.getIPData();
        JSONObject obj = new JSONObject(ipData);
        this.lugar = obj.getString("city") + ", " + obj.getString("country_name");
        this.ip = obj.getString("ip");
        this.latitud = obj.getDouble("latitude");
        this.longitud = obj.getDouble("longitude");
        this.idTransaccion=generarIDT();
        sendFunds(from,to,value);
        FileUtils.WriteTransactionToFile(this);
    }

    private String generarIDT() {
        secuencia++; //increase the sequence to avoid 2 identical transactions having the same hash
        return StringUtil.applySha256(
                remitente
                + destinatario
                + Float.toString(monto) + secuencia
        );
    }
    
       public Transaccion sendFunds(String remitente,String destinatario, float monto){
        
        return null;
    }

}
