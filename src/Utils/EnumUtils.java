/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Objetos.TipoDoc;
import Objetos.Sexo;

/**
 *
 * @author guest
 */
public class EnumUtils {
    public static TipoDoc parseTipoDoc(String tipodocStr) {
        TipoDoc[] values = TipoDoc.values();
        TipoDoc finalVal = null;
        for (int i = 0; i < values.length; i++) {
            if(values[i].toString().equals(tipodocStr)){
                finalVal = values[i];
            }
        }
        return finalVal;
    }
    public static Sexo parseSexo(String sexoStr){
        Sexo[] values = Sexo.values();
        Sexo finalval = null;
        for (int i = 0; i < values.length; i++) {
            if(values[i].toString().equals(sexoStr)){
                finalval = values[i];
            }
        }
        return finalval;
    }
}
