package com.example.daniel.findgym.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.daniel.findgym.R;
import com.example.daniel.findgym.model.Modalidade;
import com.example.daniel.findgym.model.Treinador;

import java.util.ArrayList;

public class CadastroModalidadeActivity extends AppCompatActivity {
    EditText edtDescricao;
    Spinner spnTreinador;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_modalidade);


        final ArrayList<Treinador> treinadores = (ArrayList) Treinador.listAll(Treinador.class);

        ArrayAdapter<Treinador> adapter = new ArrayAdapter<Treinador>(this, android.R.layout.simple_spinner_item, treinadores);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnTreinador = (Spinner) findViewById(R.id.spnTreinador);
        spnTreinador.setAdapter(adapter);

        edtDescricao = (EditText) findViewById(R.id.edtDescricao);


        Button btnSalvarModalidade = (Button) findViewById(R.id.btnSalvarModalidade);
        Button btnEditarModadlidade = (Button) findViewById(R.id.btnEditarModadlidade);
        Button btnExcluirModalidade = (Button) findViewById(R.id.btnExcluirModalidade);

        btnSalvarModalidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        btnEditarModadlidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnExcluirModalidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    public void salvar(){

        Treinador treinador = ((Treinador)spnTreinador.getSelectedItem());

        Modalidade modalidade = new Modalidade(edtDescricao.getText().toString(), treinador);
        modalidade.save();

        Toast.makeText(this,"Modalidade Cadastrada", Toast.LENGTH_LONG).show();
        this.finish();


    }

}
