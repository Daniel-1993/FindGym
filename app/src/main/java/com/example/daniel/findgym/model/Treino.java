package com.example.daniel.findgym.model;

import com.orm.SugarRecord;

/**
 * Created by daniel on 26/03/17.
 */
public class Treino extends SugarRecord {
    private Modalidade modalidade;
    private Usuario usuario;
    private String hora_i, getHora_f, exercicio;

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getHora_i() {
        return hora_i;
    }

    public void setHora_i(String hora_i) {
        this.hora_i = hora_i;
    }

    public String getGetHora_f() {
        return getHora_f;
    }

    public void setGetHora_f(String getHora_f) {
        this.getHora_f = getHora_f;
    }

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    public Treino(){

    }

    public Treino(Modalidade modalidade, Usuario usuario, String hora_i, String getHora_f, String exercicio) {
        this.modalidade = modalidade;
        this.usuario = usuario;
        this.hora_i = hora_i;
        this.getHora_f = getHora_f;
        this.exercicio = exercicio;
    }
}
