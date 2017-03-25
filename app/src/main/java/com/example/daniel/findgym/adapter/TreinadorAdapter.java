package com.example.daniel.findgym.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.daniel.findgym.R;
import com.example.daniel.findgym.model.Treinador;

import java.util.ArrayList;

/**
 * Created by daniel on 25/03/17.
 */
public class TreinadorAdapter extends ArrayAdapter<Treinador> {
    private final Context context;
    private final ArrayList<Treinador> listaTreinadores;

    public TreinadorAdapter(Context context, ArrayList<Treinador> listaTreinadores) {
        super(context, R.layout.linhatreinador, listaTreinadores);
        this.context = context;
        this.listaTreinadores = listaTreinadores;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linhatreinador, parent, false);
        TextView nomeTreinador = (TextView) rowView.findViewById(R.id.pNomeTreinador);
        TextView formacao = (TextView) rowView.findViewById(R.id.pFormacao);
        TextView telefone = (TextView) rowView.findViewById(R.id.pTelefone);
        nomeTreinador.setText(listaTreinadores.get(position).getNomeTreinador());
        formacao.setText(listaTreinadores.get(position).getFormacao());
        telefone.setText(listaTreinadores.get(position).getTelefone());
        return rowView;
    }
}
