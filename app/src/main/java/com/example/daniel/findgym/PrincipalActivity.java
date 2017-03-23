package com.example.daniel.findgym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btnCadastroUsuario = (Button) findViewById(R.id.btnusuario);

        btnCadastroUsuario.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrincipalActivity.this, CadastroUsuarioActivity.class);
                startActivity(intent);

            }
        });
    }
}
