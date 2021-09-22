/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;
import Utils.StringUtil;
import java.security.*; 
/**
 *
 * @author Jaider
 */
public class SalidasT {
    	public String id;
	public PublicKey destinatario; //also known as the new owner of these coins.
	public float monto; //the amount of coins they own
	public String idPadre; //the id of the transaction this output was created in
	
	//Constructor
	public SalidasT(PublicKey destinatario, float monto, String idPadre) {
		this.destinatario = destinatario;
		this.monto = monto;
		this.idPadre = idPadre;
		this.id = StringUtil.applySha256(StringUtil.getStringFromKey(destinatario)+Float.toString(monto)+idPadre);
	}
	
	//Check if coin belongs to you
	public boolean verificarMoneda(PublicKey publicKey) {
		return (publicKey == destinatario);
	}
}
