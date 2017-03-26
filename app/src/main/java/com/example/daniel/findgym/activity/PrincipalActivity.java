package com.example.daniel.findgym.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.daniel.findgym.R;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btnListaUsuarios = (Button) findViewById(R.id.btnusuario);
        Button btnlistaTreinadores = (Button) findViewById(R.id.btntreinador);
        Button btnlistaModalidades = (Button) findViewById(R.id.btnModalidade);

        btnListaUsuarios.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrincipalActivity.this, ListaUsuarioActivity.class);
                startActivity(intent);

            }
        });

        btnlistaTreinadores.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrincipalActivity.this, ListaTreinadorActivity.class);
                startActivity(intent);

            }
        });

        btnlistaModalidades.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrincipalActivity.this, CadastroModalidadeActivity.class);
                startActivity(intent);

            }
        });

    }
}
