package Objetos;

import Utils.FileUtils;
import Utils.StringUtil;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
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
public class Usuario extends Persona {

    String nickname, contraseña, id;
    private ArrayList<Billetera> billeteras;
    private String sal;
    public Usuario(String nombre, String apellido, String nacimiento, int numDoc, TipoDoc tipoDoc, Sexo sexo) {
        super(nombre, apellido, nacimiento, numDoc, tipoDoc, sexo);
    }

    public Usuario(String nickname, String contraseña, String nombre, String apellido, String nacimiento, int numDoc, TipoDoc tipoDoc, Sexo sexo) {
        super(nombre, apellido, nacimiento, numDoc, tipoDoc, sexo);
        this.billeteras = new ArrayList<Billetera>(); 
        this.nickname = nickname;
        //esta contraseña no tiene sabor, hora de echarle sal!
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < salt.length; i++) {
            sb.append(Integer.toString((salt[i] & 0xff) + 0x100, 16).substring(1));
        }
        sal = sb.toString();
        Billetera b = new Billetera(this);
        billeteras.add(b);
        this.contraseña = StringUtil.applySha256(sal + contraseña);
        //escribe los usuarios al archivo
        FileUtils.WriteUserToFile(this);      
    }
    public double getSaldoTotal() {
        double saldoTotal = 0;
        for(Billetera b: billeteras){
            saldoTotal += b.saldo;
        }
        return saldoTotal;
    }
    public ArrayList<Billetera> getBilleteras() {
        return billeteras;
    }

    public String getSal() {
        return sal;
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
    public boolean isWalletFromUser(String id){
        boolean ret = false;
        for(Billetera b: billeteras){
            if(b.id.equals(id)){
                ret = true;
            }
        }
        return ret;
    }
    public void setContraseña(String contraseña) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < salt.length; i++) {
            sb.append(Integer.toString((salt[i] & 0xff) + 0x100, 16).substring(1));
        }
        String sal = sb.toString();
        this.sal = sal;
        this.contraseña = StringUtil.applySha256(sal + contraseña);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static boolean verificarUsuario(String nickname, String input) throws IOException {
        String users = FileUtils.readFile("usuarios.json");
        Gson g = new Gson();
        int i = 0;
        boolean ret = false;
        Usuario[] usuarios = g.fromJson(users, Usuario[].class);
        String contraseña = "";
        String sal = "";
        for (Usuario u : usuarios) {
            if (u.getNickname().equals(nickname)) {
                contraseña = u.getContraseña();
                sal = u.getSal();
                System.out.println(sal);
            }
        }
        if (StringUtil.applySha256(sal + input).equals(contraseña)) {
            ret = true;
        } else {
            System.out.println(contraseña);
            System.out.println(StringUtil.applySha256(sal + input));
        }
        return ret;
    }

    public static Usuario getUsuarioByNickName(String nickname) {
        Usuario temp = null;
        String users = FileUtils.readFile("usuarios.json");
        Gson g = new Gson();        
        Usuario[] usuarios = g.fromJson(users, Usuario[].class);
        for (Usuario u : usuarios) {
            if (u.getNickname().equals(nickname)) {
                temp = u;
            }
        }
        return temp;
    }
    public static Usuario getUsuarioByWalletID(String walletID) {
        Usuario temp = null;
        String users = FileUtils.readFile("usuarios.json");
        System.out.println(users);
        Gson g = new Gson();        
        Usuario[] usuarios = g.fromJson(users, Usuario[].class);
        for (Usuario usuario : usuarios) {
            for (int j = 0; j < usuario.billeteras.size(); j++) {
                if (usuario.billeteras.get(j).getId().equals(walletID)) {
                    temp = usuario;
                }
            }
        }
        return temp;
    }
    public int getBilleterasLength(){
        return billeteras.size();
    }
    public Billetera createNewBilletera(){
        Billetera newBilletera = new Billetera(this);
        billeteras.add(newBilletera);
        newBilletera.setSaldo(50.0);
        return newBilletera;
    } 
}
