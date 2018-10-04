package com.tiqueliro.projetopi;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroActivity extends AppCompatActivity {
    private EditText etNome, etQuantidade,etFabricacao,etValidade,etLote,etCategoria;
    private Button btnSalvar;
    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_produto);
        etNome = (EditText) findViewById(R.id.etNomePlayer);
        etQuantidade = (EditText) findViewById(R.id.etQuantidade);
        etFabricacao = (EditText) findViewById(R.id.etFabricacao);
        etValidade = (EditText) findViewById(R.id.etValidade);
        etLote = (EditText) findViewById(R.id.etLote);
        etCategoria = (EditText) findViewById(R.id.etCategoria);




        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

    }

    private void salvar(){
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
            Snackbar snackbarra = new Snackbar(R.id.snackbarra);
            }
            finish();


        }
    }
}
