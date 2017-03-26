package com.example.daniel.findgym.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.daniel.findgym.R;
import com.example.daniel.findgym.model.Modalidade;

import java.util.ArrayList;

/**
 * Created by daniel on 25/03/17.
 */
public class ModalidadeAdapter extends ArrayAdapter<Modalidade> {
    private final Context context;
    private final ArrayList<Modalidade> listamodalidades;

    public ModalidadeAdapter(Context context, ArrayList<Modalidade> listamodalidades) {
        super(context, R.layout.linhamodalidade);
        this.context = context;
        this.listamodalidades = listamodalidades;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linhamodalidade, parent, false);
        TextView descricao = (TextView) rowView.findViewById(R.id.pDescricao);
        TextView treinador = (TextView) rowView.findViewById(R.id.pTreinador);
        descricao.setText(listamodalidades.get(position).getDescricao());
        treinador.setText(listamodalidades.get(position).getTreinador().getNomeTreinador());
        return rowView;
    }
}
