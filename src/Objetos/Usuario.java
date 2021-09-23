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
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Usuario(String nombre, String apellido, String nacimiento, int numDoc, TipoDoc tipoDoc, Sexo sexo) {
        super(nombre, apellido, nacimiento, numDoc, tipoDoc, sexo);
    }

    public Usuario(String nickname, String contraseña, String nombre, String apellido, String nacimiento, int numDoc, TipoDoc tipoDoc, Sexo sexo) {
        super(nombre, apellido, nacimiento, numDoc, tipoDoc, sexo);
        this.nickname = nickname;
        //esta contraseña no tiene sabor, hora de echarle sal!
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < salt.length; i++) {
            sb.append(Integer.toString((salt[i] & 0xff) + 0x100, 16).substring(1));
        }
        String sal = sb.toString();
        try {
            FileUtils.writeFile("sal.txt", sal);
            this.contraseña = StringUtil.applySha256(sal + contraseña);
        } catch (IOException ex) {
        }
        //escribe los usuarios al archivo
        FileUtils.WriteUserToFile(this);
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
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < salt.length; i++) {
            sb.append(Integer.toString((salt[i] & 0xff) + 0x100, 16).substring(1));
        }
        String sal = sb.toString();
        try {
            FileUtils.writeFile("sal.txt", sal);
            this.contraseña = StringUtil.applySha256(sal + contraseña);
        } catch (IOException ex) {
        }
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
        int j = 0;
        int k = 0;
        int l = 0;
        boolean ret = false;
        Usuario[] usuarios = g.fromJson(users, Usuario[].class);
        String contraseña = "";
        String sal = "";
        for (Usuario u : usuarios) {
            i++;
            if (u.getNickname().equals(nickname)) {
                j = i;
                contraseña = u.getContraseña();
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader("sal.txt"))) {
            {
                for (String line; (line = br.readLine()) != null;) {
                    l++;
                    if (l == j) {
                        sal = line;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (java.lang.ArrayIndexOutOfBoundsException exc) {
        }
        if (StringUtil.applySha256(sal + input).equals(contraseña)) {
            ret = true;
        }
        return ret;
    }
}
