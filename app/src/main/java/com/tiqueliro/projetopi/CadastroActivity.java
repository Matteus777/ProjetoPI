package com.tiqueliro.projetopi;

import android.annotation.SuppressLint;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroActivity extends AppCompatActivity {
    private EditText etNome, etQuantidade,etFabricacao,etValidade,etLote,;
    private Spinner spnCategoria;
    private Button btnSalvar;
    private FirebaseDatabase database;
    private DatabaseReference reference;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        etNome = (EditText) findViewById(R.id.etNome);
        etQuantidade = (EditText) findViewById(R.id.etQuantidade);
        etFabricacao = (EditText) findViewById(R.id.etFabricacao);
        etValidade = (EditText) findViewById(R.id.etValidade);
        etLote = (EditText) findViewById(R.id.etLote);
        spnCategoria = (Spinner) findViewById(R.id.spnCategoria);





        btnSalvar = (Button) findViewById(R.id.btnSalvarCadastro);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar(view);
            }
        });

    }

    private void salvar(View view){
        String nome = etNome.getText().toString();
        String quantidade = etQuantidade.getText().toString();
        String fabricacao = etFabricacao.getText().toString();
        String validade = etValidade.getText().toString();
        String lote = etLote.getText().toString();
        String categoria = etCategoria.getText().toString();

        if ( ! nome.isEmpty() ){
            database = FirebaseDatabase.getInstance();
            reference = database.getReference();

            Produto p = new Produto();
            p.setNome( nome );
            p.setQuantidade(Integer.parseInt(quantidade));
            p.setFabricacao(fabricacao);
            p.setValidade(validade);
            p.setLote(lote);
            p.setCategoria(quantidade);
            reference.child("produtos").push().setValue( p );
            }else {
                Snackbar.make(view,"Preencha todos os campos", Snackbar.LENGTH_LONG).setAction("OK", null).show();

        }
        finish();


    }

}
