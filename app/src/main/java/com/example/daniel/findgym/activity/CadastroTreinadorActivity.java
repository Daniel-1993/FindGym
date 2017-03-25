package com.example.daniel.findgym.activity;

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

        edtNomeTreinador = (EditText) findViewById(R.id.edtNomeTreinador);
        edtFormacao = (EditText) findViewById(R.id.edtFormacao);
        edtTelefone = (EditText) findViewById(R.id.edtTelefone);

        btnSalvarTreinador = (Button) findViewById(R.id.btnSalvarTreinador);
        btnEditarTreinador = (Button) findViewById(R.id.btnEditarTreinador);
        btnExcluirTreinador = (Button) findViewById(R.id.btnExcluirTreinador);

        btnSalvarTreinador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });


    }

    public void salvar(){
        Treinador treinador = new Treinador(edtNomeTreinador.getText().toString(), edtFormacao.getText().toString(), edtTelefone.getText().toString());
        treinador.save();
        Toast.makeText(this, "Treinador cadastrado com sucesso!", Toast.LENGTH_LONG).show();
        this.finish();
    }
}
