package com.example.daniel.findgym.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daniel.findgym.R;
import com.example.daniel.findgym.model.Treinador;

public class CadastroTreinadorActivity extends AppCompatActivity {
    EditText edtNomeTreinador, edtFormacao, edtTelefone;
    Button btnSalvarTreinador, btnEditarTreinador, btnExcluirTreinador;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_treinador);
        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("id");

        String pnomeTreinador = (String) intent.getSerializableExtra("NomeUsuario");
        String pformacao = (String) intent.getSerializableExtra("Formacao");
        String ptelefone = (String) intent.getSerializableExtra("Telefone");



        edtNomeTreinador = (EditText) findViewById(R.id.edtNomeTreinador);
        edtNomeTreinador.setText(pnomeTreinador);

        edtFormacao = (EditText) findViewById(R.id.edtFormacao);
        edtFormacao.setText(pformacao);

        edtTelefone = (EditText) findViewById(R.id.edtTelefone);
        edtTelefone.setText(ptelefone);


        btnSalvarTreinador = (Button) findViewById(R.id.btnSalvarTreinador);
        btnEditarTreinador = (Button) findViewById(R.id.btnEditarTreinador);
        btnExcluirTreinador = (Button) findViewById(R.id.btnExcluirTreinador);

        btnSalvarTreinador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        btnEditarTreinador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editar();
            }
        });

        if (id !=0) {
            btnSalvarTreinador.setEnabled(false);
            btnSalvarTreinador.setClickable(false);
            btnSalvarTreinador.setVisibility(View.INVISIBLE);
        }else{
            btnEditarTreinador.setEnabled(false);
            btnEditarTreinador.setClickable(false);
            btnEditarTreinador.setVisibility(View.INVISIBLE);

        }


    }

    public void salvar(){
        Treinador treinador = new Treinador(edtNomeTreinador.getText().toString(), edtFormacao.getText().toString(), edtTelefone.getText().toString());
        treinador.save();
        Toast.makeText(this, "Treinador cadastrado com sucesso!", Toast.LENGTH_LONG).show();
        this.finish();
    }

    public void editar() {

        edtNomeTreinador = (EditText) findViewById(R.id.edtNomeTreinador);
        edtFormacao = (EditText) findViewById(R.id.edtFormacao);
        edtTelefone = (EditText) findViewById(R.id.edtTelefone);

        Treinador treinador = Treinador.findById(Treinador.class, id);

        treinador.setNomeTreinador(edtNomeTreinador.getText().toString());
        treinador.setFormacao(edtFormacao.getText().toString());
        treinador.setTelefone(edtTelefone.getText().toString());

        treinador.save();

        Toast.makeText(this,"Treinador Alterado",Toast.LENGTH_LONG).show();
        this.finish();
    }
}
