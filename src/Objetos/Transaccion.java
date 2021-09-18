package Objetos;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Transaccion {
    long timestamp;
    String remitente,destinatario,ip,lugar;
    double latitud,longitud,monto;
    ArrayList<Cuenta> lasCuentas;

    public Transaccion(long timestamp, String remitente, String destinatario, String ip, String lugar, double latitud, double longitud, double monto, ArrayList<Cuenta> lasCuentas) {
        this.timestamp = timestamp;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.ip = ip;
        this.lugar = lugar;
        this.latitud = latitud;
        this.longitud = longitud;
        this.monto = monto;
        this.lasCuentas = lasCuentas;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }



    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public ArrayList<Cuenta> getLasCuentas() {
        return lasCuentas;
    }

    public void setLasCuentas(ArrayList<Cuenta> lasCuentas) {
        this.lasCuentas = lasCuentas;
    }  
}
