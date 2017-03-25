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
import com.example.daniel.findgym.adapter.TreinadorAdapter;
import com.example.daniel.findgym.model.Treinador;

import java.util.ArrayList;

public class ListaTreinadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_treinador);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaTreinadorActivity.this, CadastroTreinadorActivity.class);
                intent.putExtra("id", 0);
                startActivity(intent);
            }
        });
    }

    protected void onResume()
    {
        super.onResume();
        ListView listatreinador = (ListView) findViewById(R.id.lstTreinadores);

        final ArrayList<Treinador> usr = (ArrayList<Treinador>)
                Treinador.listAll(Treinador.class);

        ArrayAdapter adapter = new TreinadorAdapter(this, usr);
        listatreinador.setAdapter(adapter);

        listatreinador.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaTreinadorActivity.this, CadastroTreinadorActivity.class);
                intent.putExtra("id", usr.get(i).getId().intValue());
                intent.putExtra("NomeUsuario", usr.get(i).getNomeTreinador());
                intent.putExtra("Formacao", usr.get(i).getFormacao());
                intent.putExtra("Telefone", usr.get(i).getTelefone());
                startActivity(intent);

            }
        });
    }

}
