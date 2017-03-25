package com.example.daniel.findgym.model;

import com.orm.SugarRecord;

/**
 * Created by daniel on 24/03/17.
 */
public class Usuario extends SugarRecord {
    private String nomeUsuario;
    private String email;
    private String cpf;
    private String senha;

    public  Usuario(){

    }

    public Usuario(String nomeUsuario, String email, String cpf, String senha){
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }
}
