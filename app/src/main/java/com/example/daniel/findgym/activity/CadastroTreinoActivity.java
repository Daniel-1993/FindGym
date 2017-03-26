package com.example.daniel.findgym.activity;

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
import com.example.daniel.findgym.model.Treino;
import com.example.daniel.findgym.model.Usuario;

import java.util.ArrayList;

public class CadastroTreinoActivity extends AppCompatActivity {
    Spinner spnUsuario, spnModalidade;
    EditText edtHora_i, edtHora_f, edtExercicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrotreino);

        edtHora_i = (EditText) findViewById(R.id.edtHora_i);
        edtHora_f = (EditText) findViewById(R.id.edtHora_f);
        edtExercicos = (EditText) findViewById(R.id.edtExercicos);

        spnUsuario = (Spinner) findViewById(R.id.spnUsuario);
        final ArrayList<Usuario> usuarios = (ArrayList) Usuario.listAll(Usuario.class);
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(this, android.R.layout.simple_spinner_item, usuarios);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnUsuario.setAdapter(adapter);


        spnModalidade = (Spinner) findViewById(R.id.spnModalidade);
        final ArrayList<Modalidade> modalidades = (ArrayList) Modalidade.listAll(Modalidade.class);
        ArrayAdapter<Modalidade> adapter2 = new ArrayAdapter<Modalidade>(this, android.R.layout.simple_spinner_item, modalidades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnModalidade.setAdapter(adapter2);



        Button btnSalvarTreino = (Button) findViewById(R.id.btnSalvarTreino);

        btnSalvarTreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();

            }
        });

    }

    public void salvar(){
        Usuario usuario = ((Usuario)spnUsuario.getSelectedItem());
        Modalidade modalidade = ((Modalidade)spnModalidade.getSelectedItem());

        Treino treino = new Treino(modalidade, usuario, edtHora_i.getText().toString(), edtHora_f.getText().toString(), edtExercicos.getText().toString());
        modalidade.save();

        Toast.makeText(this,"Modalidade Cadastrada", Toast.LENGTH_LONG).show();
        this.finish();
    }
}
