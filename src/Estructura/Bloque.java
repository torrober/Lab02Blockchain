/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Objetos.Transaccion1;
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
    public String merkleRoot;
    public ArrayList<Transaccion1> transactions = new ArrayList<Transaccion1>();
    public long timeStamp;
    public int nonce;

    public Bloque(String antes) {
        this.idAntes = antes;
        this.timeStamp = new Date().getTime();
        this.id = generarId();
    }

    public String generarId() {
        String gId = StringUtil.applySha256(
                idAntes
                + Long.toString(timeStamp)
                + merkleRoot
        );
        return gId;
    }

    public void minarbloque(int diff) {
        String objetivo = new String(new char[diff]).replace('\0', '0');  
        while (!id.substring(0, diff).equals(objetivo)) {
            nonce++;
            id = generarId();
        }

    }
    public boolean addTransaccion(Transaccion1 transaction) {
		//process transaction and check if valid, unless block is genesis block then ignore.
		if(transaction == null) return false;		
		if((idAntes != "0")) {
			if((transaction.procesarTransaccion()!= true)) {
				return false;
			}
		}
		transactions.add(transaction);
		return true;
	}

}
