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
    Usuario remitente,destinatario;
    long timestamp;
    String ip,lugar;
    double latitud,longitud;
    ArrayList<Usuario> losUsuarios;

    public Transaccion(Usuario remitente, Usuario destinatario, long timestamp, String ip, String lugar, double latitud, double longitud, ArrayList<Usuario> losUsuarios) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.timestamp = timestamp;
        this.ip = ip;
        this.lugar = lugar;
        this.latitud = latitud;
        this.longitud = longitud;
        this.losUsuarios = losUsuarios;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
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

    public ArrayList<Usuario> getLosUsuarios() {
        return losUsuarios;
    }

    public void setLosUsuarios(ArrayList<Usuario> losUsuarios) {
        this.losUsuarios = losUsuarios;
    }
    
    
}
