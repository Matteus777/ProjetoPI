package com.tiqueliro.projetopi;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroCategoria extends AppCompatActivity {
EditText etNome;
Button btnSalvar;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_categoria);
    etNome = findViewById(R.id.etNomeCategoria);
    btnSalvar = findViewById(R.id.btnSalvarCategoria);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar(view);
            }
        });

    }

    private void salvar(View view){
        String nome = etNome.getText().toString();


        if ( ! nome.isEmpty() ){
            database = FirebaseDatabase.getInstance();
            reference = database.getReference();

            Categoria c = new Categoria();
            c.setNome( nome );

            reference.child("categorias").push().setValue( c );
        }else {
            Snackbar.make(view,"Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("OK", null).show();

        }
        finish();


    }

}


