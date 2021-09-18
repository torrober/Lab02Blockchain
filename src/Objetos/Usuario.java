package Objetos;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Usuario extends Persona{
    String nickname,contraseña,id;
    

    public Usuario(String nombre, String apellido, String nacimiento, int numDoc, TipoDoc tipoDoc, Sexo sexo) {
        super(nombre, apellido, nacimiento, numDoc, tipoDoc, sexo);
    }

    public Usuario(String nickname, String contraseña, String nombre, String apellido, String nacimiento, int numDoc, TipoDoc tipoDoc, Sexo sexo) {
        super(nombre, apellido, nacimiento, numDoc, tipoDoc, sexo);
        this.nickname = nickname;
        this.contraseña = contraseña;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    
    
    
    





    
    
}
