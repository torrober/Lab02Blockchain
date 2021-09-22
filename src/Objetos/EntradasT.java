/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Objetos.SalidasT;

/**
 *
 * @author Jaider
 */
public class EntradasT {

    public String idSalida; //Reference to TransactionOutputs -> transactionId
    public SalidasT UTXO; //Contains the Unspent transaction output

    public EntradasT(String ids) {
        this.idSalida = ids;
    }
}
