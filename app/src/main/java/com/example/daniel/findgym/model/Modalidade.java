package com.example.daniel.findgym.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

/**
 * Created by daniel on 25/03/17.
 */
public class Modalidade extends SugarRecord implements Parcelable {
    private String descricao;
    private Treinador treinador;


    protected Modalidade(Parcel in) {
        descricao = in.readString();
        treinador = in.readParcelable(Treinador.class.getClassLoader());
    }

    public static final Creator<Modalidade> CREATOR = new Creator<Modalidade>() {
        @Override
        public Modalidade createFromParcel(Parcel in) {
            return new Modalidade(in);
        }

        @Override
        public Modalidade[] newArray(int size) {
            return new Modalidade[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(descricao);
        parcel.writeParcelable(treinador, i);
    }

    @Override
    public String toString()
    {
        return descricao;
    }
}
