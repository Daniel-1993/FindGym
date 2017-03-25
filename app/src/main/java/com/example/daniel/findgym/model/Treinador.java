package com.example.daniel.findgym.model;

import com.orm.SugarRecord;

/**
 * Created by daniel on 25/03/17.
 */
public class Treinador extends SugarRecord {
    private String nomeTreinador;
    private String formacao;
    private  String telefone;

    public String getNomeTreinador() {
        return nomeTreinador;
    }

    public void setNomeTreinador(String nomeTreinador) {
        this.nomeTreinador = nomeTreinador;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Treinador(String nomeTreinador, String formacao, String telefone) {
        this.nomeTreinador = nomeTreinador;
        this.formacao = formacao;
        this.telefone = telefone;
    }

    public Treinador(){

    }
}
