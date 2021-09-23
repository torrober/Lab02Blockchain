/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Estructura.Cadena;
import Utils.StringUtil;
import java.security.*;
import java.util.ArrayList;

/**
 *
 * @author Jaider
 */
public class Transaccion1 {

    public String idTransaccion;
    public PublicKey remitente;
    public PublicKey destinatario;
    public float monto;
    public byte[] signature;

    public ArrayList<EntradasT> inputs = new ArrayList<EntradasT>();
    public ArrayList<SalidasT> outputs = new ArrayList<SalidasT>();

    private static int secuencia = 0;

    public Transaccion1(PublicKey from, PublicKey to, float value, ArrayList<EntradasT> inputs) {
        this.remitente = from;
        this.destinatario = to;
        this.monto = value;
        this.inputs = inputs;
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
			i.UTXO = Cadena.UTXOs.get(i.idSalida);
		}
		//check if transaction is valid:
		if(getvalorEntradas() < Cadena.minimumTransaction) {
			return false;
		}
		
		//generate transaction outputs:
		float leftOver = getvalorEntradas() - monto; //get value of inputs then the left over change:
		idTransaccion = generarIDT();
		outputs.add(new SalidasT( this.destinatario, monto,idTransaccion)); //send value to recipient
		outputs.add(new SalidasT( this.remitente, leftOver,idTransaccion)); //send the left over 'change' back to sender		
				
		//add outputs to Unspent list
		for(SalidasT o : outputs) {
			Cadena.UTXOs.put(o.id , o);
		}
		
		//remove transaction inputs from UTXO lists as spent:
		for(EntradasT i : inputs) {
			if(i.UTXO == null) continue; //if Transaction can't be found skip it 
			Cadena.UTXOs.remove(i.UTXO.id);
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
