package com.example.daniel.findgym.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daniel.findgym.R;
import com.example.daniel.findgym.model.Usuario;

public class CadastroUsuarioActivity extends AppCompatActivity {
    EditText edtNomeUsuario, edtEmail, edtCPF, edtSenha;
    Button btnSalvarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        edtNomeUsuario = (EditText) findViewById(R.id.edtNomeUsuario);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtCPF = (EditText) findViewById(R.id.edtCPF);
        edtSenha = (EditText)findViewById(R.id.edtSenha);

        btnSalvarUsuario = (Button) findViewById(R.id.btnCadastroUsuario);

        btnSalvarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });


    }

    public void salvar(){
        Usuario u = new Usuario(edtNomeUsuario.getText().toString(), edtEmail.getText().toString(), edtCPF.getText().toString(), edtSenha.getText().toString());
        u.save();
        Toast.makeText(this, "Usuario cadastrado com sucesso!", Toast.LENGTH_LONG).show();
        this.finish();
    }

}
