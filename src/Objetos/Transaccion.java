/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Utils.StringUtil;
import java.security.*;
import java.util.ArrayList;
import org.json.JSONObject;
import Utils.IPDetails;
import java.io.IOException;
import lab01blockchain.BlockChain;

/**
 *
 * @author Jaider
 */
public class Transaccion {

    public String idTransaccion,ip, lugar;
    public PublicKey remitente;
    public PublicKey destinatario;
    public float monto;
    public double latitud, longitud;
    public long timestamp;
    public byte[] signature;

    public ArrayList<EntradasT> inputs = new ArrayList<EntradasT>();
    public ArrayList<SalidasT> outputs = new ArrayList<SalidasT>();

    private static int secuencia = 0;

    public Transaccion(PublicKey from, PublicKey to, float value, ArrayList<EntradasT> inputs) throws IOException {
        this.remitente = from;
        this.destinatario = to;
        this.monto = value;
        this.inputs = inputs;
        String ipData = IPDetails.getIPData();
        JSONObject obj = new JSONObject(ipData);
        this.lugar = obj.getString("city") + ", " + obj.getString("country_name");
        this.ip = obj.getString("ip");
        this.latitud = obj.getDouble("latitude");
        this.longitud = obj.getDouble("longitude");
    }

    private String generarIDT() {
        secuencia++; //increase the sequence to avoid 2 identical transactions having the same hash
        return StringUtil.applySha256(
                StringUtil.getStringFromKey(remitente)
                + StringUtil.getStringFromKey(destinatario)
                + Float.toString(monto) + secuencia
        );
    }

    public void generarSignature(PrivateKey privateKey) {
        String data = StringUtil.getStringFromKey(remitente) + StringUtil.getStringFromKey(destinatario) + Float.toString(monto);
        signature = StringUtil.applyECDSASig(privateKey, data);
    }
    
    public boolean validarSignature() {
	String data = StringUtil.getStringFromKey(remitente) + StringUtil.getStringFromKey(destinatario) + Float.toString(monto)	;
	return StringUtil.verifyECDSASig(remitente, data, signature);
}
    
    public boolean procesarTransaccion() {
		
		if(validarSignature() == false) {
			return false;
		}
				
		//gather transaction inputs (Make sure they are unspent):
		for(EntradasT i : inputs) {
			i.UTXO = BlockChain.UTXOs.get(i.idSalida);
		}
		//check if transaction is valid:
		if(getvalorEntradas() < BlockChain.minimumTransaction) {
			return false;
		}
		
		//generate transaction outputs:
		float leftOver = getvalorEntradas() - monto; //get value of inputs then the left over change:
		idTransaccion = generarIDT();
		outputs.add(new SalidasT( this.destinatario, monto,idTransaccion)); //send value to recipient
		outputs.add(new SalidasT( this.remitente, leftOver,idTransaccion)); //send the left over 'change' back to sender		
				
		//add outputs to Unspent list
		for(SalidasT o : outputs) {
			BlockChain.UTXOs.put(o.id , o);
		}
		
		//remove transaction inputs from UTXO lists as spent:
		for(EntradasT i : inputs) {
			if(i.UTXO == null) continue; //if Transaction can't be found skip it 
			BlockChain.UTXOs.remove(i.UTXO.id);
		}
		
		return true;
	}
	
//returns sum of inputs(UTXOs) values
	public float getvalorEntradas() {
		float total = 0;
		for(EntradasT i : inputs) {
			if(i.UTXO == null) continue; //if Transaction can't be found skip it 
			total += i.UTXO.total;
		}
		return total;
	}

//returns sum of outputs:
	public float getvalorSalidas() {
		float total = 0;
		for(SalidasT o : outputs) {
			total += o.total;
		}
		return total;
	}

}
