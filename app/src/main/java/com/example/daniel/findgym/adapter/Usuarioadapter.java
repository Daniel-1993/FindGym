package com.example.daniel.findgym.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.daniel.findgym.R;
import com.example.daniel.findgym.model.Usuario;

import java.util.ArrayList;

/**
 * Created by daniel on 24/03/17.
 */
public class Usuarioadapter extends ArrayAdapter<Usuario> {
    private final Context context;
    private final ArrayList<Usuario> listaUsuarios;


    public Usuarioadapter(Context context, ArrayList<Usuario> listaUsuarios) {
        super(context, R.layout.linhausuario, listaUsuarios);
        this.context = context;
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linhausuario, parent, false);
        TextView nomeUsuario = (TextView) rowView.findViewById(R.id.pNomeUsuario);
        TextView email = (TextView) rowView.findViewById(R.id.pEmail);
        TextView cpf = (TextView) rowView.findViewById(R.id.pCpf);
        TextView senha = (TextView) rowView.findViewById(R.id.pSenha);
        nomeUsuario.setText(listaUsuarios.get(position).getNomeUsuario());
        email.setText(listaUsuarios.get(position).getEmail());
        cpf.setText(listaUsuarios.get(position).getCpf());
        senha.setText(listaUsuarios.get(position).getSenha());
        return rowView;
    }
}
