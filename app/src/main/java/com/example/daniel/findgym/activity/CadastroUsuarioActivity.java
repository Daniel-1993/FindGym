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
import android.content.Intent;

import com.example.daniel.findgym.R;
import com.example.daniel.findgym.model.Usuario;

public class CadastroUsuarioActivity extends AppCompatActivity {
    EditText edtNomeUsuario, edtEmail, edtCPF, edtSenha;
    Button btnSalvarUsuario, btnEditarUsuario;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("id");

        String pnomeUsuario = (String) intent.getSerializableExtra("Nome");
        String pEmail = (String) intent.getSerializableExtra("E-mail");
        String pCpf = (String) intent.getSerializableExtra("CPF");
        String pSenha = (String) intent.getSerializableExtra("Senha");


        edtNomeUsuario = (EditText) findViewById(R.id.edtNomeUsuario);
        edtNomeUsuario.setText(pnomeUsuario);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtEmail.setText(pEmail);

        edtCPF = (EditText) findViewById(R.id.edtCPF);
        edtCPF.setText(pCpf);

        edtSenha = (EditText)findViewById(R.id.edtSenha);
        edtSenha.setText(pSenha);

        btnSalvarUsuario = (Button) findViewById(R.id.btnCadastroUsuario);
        btnEditarUsuario = (Button) findViewById(R.id.btnEditarUsuario);

        btnSalvarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        btnEditarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editar();
            }
        });

        if (id !=0) {
            btnSalvarUsuario.setEnabled(false);
            btnSalvarUsuario.setClickable(false);
            btnSalvarUsuario.setVisibility(View.INVISIBLE);
        }else{
            btnEditarUsuario.setEnabled(false);
            btnEditarUsuario.setClickable(false);
            btnEditarUsuario.setVisibility(View.INVISIBLE);

        }


    }

    public void salvar(){
        Usuario usuario = new Usuario(edtNomeUsuario.getText().toString(), edtEmail.getText().toString(), edtCPF.getText().toString(), edtSenha.getText().toString());
        usuario.save();
        Toast.makeText(this, "Usuario cadastrado com sucesso!", Toast.LENGTH_LONG).show();
        this.finish();
    }

    public void editar() {

        edtNomeUsuario = (EditText) findViewById(R.id.edtNomeUsuario);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtCPF = (EditText) findViewById(R.id.edtCPF);
        edtSenha = (EditText)findViewById(R.id.edtSenha);

        Usuario usuario = Usuario.findById(Usuario.class, id);

        usuario.setNomeUsuario(edtNomeUsuario.getText().toString());
        usuario.setEmail(edtEmail.getText().toString());
        usuario.setCpf(edtCPF.getText().toString());
        usuario.setSenha(edtSenha.getText().toString());

        usuario.save();

        Toast.makeText(this,"Usuario Alterado",Toast.LENGTH_LONG).show();
        this.finish();
    }

}
