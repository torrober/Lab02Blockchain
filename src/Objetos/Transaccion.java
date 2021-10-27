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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import lab01blockchain.BlockChain;

/**
 *
 * @author Jaider
 */
public class Transaccion {

    public String idTransaccion, ip, lugar;
    public String remitente;
    public String destinatario;
    public double monto;
    public double latitud, longitud;
    public long timestamp;
    private static int secuencia = 0;

    public Transaccion(String from, String to, double value) throws IOException {
        this.remitente = from;
        this.destinatario = to;
        this.monto = value;
        String ipData = IPDetails.getIPData();
        JSONObject obj = new JSONObject(ipData);
        this.lugar = obj.getString("city") + ", " + obj.getString("country_name");
        this.ip = obj.getString("ip");
        this.latitud = obj.getDouble("latitude");
        this.longitud = obj.getDouble("longitude");
        this.idTransaccion = generarIDT();
        sendFunds(from, to, value);
        FileUtils.WriteTransactionToFile(this);
        Transaccion.toResume(this);
    }

    public static void toResume(Transaccion t) throws IOException {
        String resumen = "<!DOCTYPE html><html lang=\"en\"><head> <meta charset=\"UTF-8\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <title>Resumen</title> <link href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap.css\" rel=\"stylesheet\"> <style>body{font-family: -apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto, Oxygen, Ubuntu, Cantarell, \"Open Sans\", \"Helvetica Neue\", sans-serif;}.options{text-align: center;}@media print{.no-print, .no-print *{display: none !important;}}</style></head><body> <div class=\"container\"> <h1>Transaccion</h1> <table class=\"table table-bordered\"> <tbody> <tr> <td>Billetera del remitente</td><td>{{issuer_wallet_id}}</td></tr><tr> <td>Billetera del destinatario</td><td>{{recipient_wallet_id}}</td></tr><tr> <td>Valor</td><td>${{transaction_value}}</td></tr><tr> <td>Fecha</td><td>{{transaction_date}}</td></tr><tr> <td>IP del remitente</td><td>{{transaction_ip}}</td></tr><tr> <td>Localización</td><td> <img id=\"location\" src=\"https://api.mapbox.com/styles/v1/mapbox/satellite-streets-v11/static/{{long}}},{{lat}},11,0/200x200@2x?access_token=pk.eyJ1IjoidG9ycm9iZXIiLCJhIjoiY2tzcXo4N3l4MGhkZDJ2cDdqaHN0eW03cSJ9.pqxKGDHiEvTkfeoFDBFzSw\" width=\"200\" height=\"200\"> </td></tr></tbody> </table> <div class=\"options no-print\"> <a href=\"?print=true\"><button class=\"btn btn-success\" id=\"print\">Imprimir</button></a> <a href=\"?closeFrame=true\"><button class=\"btn btn-danger\" id=\"close\">Cerrar resumen</button></a> </div></div><script>window.onload=window.print();</script></body></html>";
        resumen = resumen.replace("{{transaction_id}}", t.idTransaccion);
        resumen = resumen.replace("{{issuer_wallet_id}}", t.remitente);
        resumen = resumen.replace("{{recipient_wallet_id}}", t.destinatario);
        NumberFormat formatter = new DecimalFormat("#0.000");
        resumen = resumen.replace("{{transaction_value}}", "" + formatter.format(t.monto));
        resumen = resumen.replace("{{transaction_date}}", "");
        resumen = resumen.replace("{{transaction_ip}}", t.ip);
        resumen = resumen.replace("{{long}}}", "" + t.longitud);
        resumen = resumen.replace("{{lat}}", "" + t.latitud);
        FileUtils.writeFile("resumen-" + t.idTransaccion + ".html", resumen);
    }

    private String generarIDT() {
        secuencia++; 
        return StringUtil.applySha256(
                remitente
                + destinatario
                + Double.toString(monto) + secuencia
        );
    }

    public Transaccion sendFunds(String remitente, String destinatario, double monto) {

        return null;
    }

}
