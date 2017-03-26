package com.example.daniel.findgym.model;

import com.orm.SugarRecord;

/**
 * Created by daniel on 25/03/17.
 */
public class Modalidade extends SugarRecord {
    private String descricao;
    private Treinador treinador;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }

    public Modalidade(){

    }

    public Modalidade(String descricao, Treinador treinador) {
        this.descricao = descricao;
        this.treinador = treinador;
    }
}
