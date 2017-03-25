package com.example.daniel.findgym.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.daniel.findgym.R;
import com.example.daniel.findgym.adapter.Usuarioadapter;
import com.example.daniel.findgym.model.Usuario;

import java.util.ArrayList;

public class ListaUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaUsuarioActivity.this, CadastroUsuarioActivity.class);
                intent.putExtra("id", 0);
                startActivity(intent);
            }
        });

    }

    protected void onResume()
    {
        super.onResume();
        ListView listaUsuario = (ListView) findViewById(R.id.lstUsuarios);

        final ArrayList<Usuario> usr = (ArrayList<Usuario>)
                Usuario.listAll(Usuario.class);

        ArrayAdapter adapter = new Usuarioadapter(this, usr);
        listaUsuario.setAdapter(adapter);

        listaUsuario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaUsuarioActivity.this, CadastroUsuarioActivity.class);
                intent.putExtra("id", usr.get(i).getId().intValue());
                intent.putExtra("Nome", usr.get(i).getNomeUsuario());
                intent.putExtra("E-mail", usr.get(i).getEmail());
                intent.putExtra("CPF", usr.get(i).getCpf());
                intent.putExtra("Senha", usr.get(i).getSenha());

                startActivity(intent);

            }
        });
    }


}
