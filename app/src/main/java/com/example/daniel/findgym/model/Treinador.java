package com.example.daniel.findgym.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

/**
 * Created by daniel on 25/03/17.
 */
public class Treinador extends SugarRecord implements Parcelable{
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

    protected Treinador(Parcel in) {
        nomeTreinador = in.readString();
        formacao = in.readString();
        telefone = in.readString();
    }

    public static final Creator<Treinador> CREATOR = new Creator<Treinador>() {
        @Override
        public Treinador createFromParcel(Parcel in) {
            return new Treinador(in);
        }

        @Override
        public Treinador[] newArray(int size) {
            return new Treinador[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nomeTreinador);
        parcel.writeString(formacao);
        parcel.writeString(telefone);
    }

    @Override
    public String toString()
    {
        return nomeTreinador;
    }



}
