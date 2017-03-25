package com.example.daniel.findgym.model;

import android.os.Parcel;

import com.orm.SugarRecord;

/**
 * Created by daniel on 24/03/17.
 */
public class Usuario extends SugarRecord {
    private String nomeUsuario;
    private String email;
    private String cpf;
    private String senha;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public  Usuario(){

    }

    public Usuario(String nomeUsuario, String email, String cpf, String senha){
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }

    protected Usuario(Parcel from){
        nomeUsuario = from.readString();
        email = from.readString();
        cpf = from.readString();
        senha = from.readString();

    }
}
