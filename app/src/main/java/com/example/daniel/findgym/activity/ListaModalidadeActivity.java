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
import com.example.daniel.findgym.adapter.ModalidadeAdapter;
import com.example.daniel.findgym.model.Modalidade;

import java.util.ArrayList;

public class ListaModalidadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_modalidade);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaModalidadeActivity.this, CadastroModalidadeActivity.class);
                intent.putExtra("id", 0);
                startActivity(intent);
            }
        });
    }

    protected void onResume()
    {
        super.onResume();
        final ArrayList<Modalidade> moda = (ArrayList<Modalidade>) Modalidade.listAll(Modalidade.class);

        ListView listamodalidade = (ListView) findViewById(R.id.lstModalidade);
        ArrayAdapter adapter = new ModalidadeAdapter(this, moda);
        listamodalidade.setAdapter(adapter);

        listamodalidade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaModalidadeActivity.this, CadastroModalidadeActivity.class);
                intent.putExtra("id", moda.get(i).getId().intValue());
                intent.putExtra("Descricao", moda.get(i).getDescricao());
                intent.putExtra("Treinador", moda.get(i).getTreinador().getId());
                startActivity(intent);

            }
        });
    }
}
