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
        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("id");

        String pDescricao = (String) intent.getSerializableExtra("Descricao");


        final ArrayList<Treinador> treinadores = (ArrayList) Treinador.listAll(Treinador.class);

        ArrayAdapter<Treinador> adapter = new ArrayAdapter<Treinador>(this, android.R.layout.simple_spinner_item, treinadores);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnTreinador = (Spinner) findViewById(R.id.spnTreinador);
        spnTreinador.setAdapter(adapter);

        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        edtDescricao.setText(pDescricao);


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
                editar();
            }
        });

        btnExcluirModalidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excluir();
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

    public void editar() {

        Treinador treinador = ((Treinador) spnTreinador.getSelectedItem());
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);

        Modalidade modalidade = Modalidade.findById(Modalidade.class, id);

        modalidade.setDescricao(edtDescricao.getText().toString());
        modalidade.setTreinador(treinador);

        modalidade.save();

        Toast.makeText(this,"Modalidade Alterada",Toast.LENGTH_LONG).show();
        this.finish();
    }

    public void excluir() {

        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        Treinador treinador = ((Treinador) spnTreinador.getSelectedItem());

        Modalidade modalidade = Modalidade.findById(Modalidade.class, id);

        modalidade.setDescricao(edtDescricao.getText().toString());
        modalidade.setTreinador(treinador);

        modalidade.delete();

        Toast.makeText(this,"Modalidade Excluida",Toast.LENGTH_LONG).show();
        this.finish();
    }
}
