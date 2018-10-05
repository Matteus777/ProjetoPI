package com.tiqueliro.projetopi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormularioUsuarioActivity extends AppCompatActivity {
    private EditText  etEmail, etSenha, etConfirma;
    private Button btnEnviar;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_usuario);
        etEmail = findViewById(R.id.etEmailCadastro);
        etSenha = findViewById(R.id.etSenhaCadastro);
        etConfirma = findViewById(R.id.etConfirmaSenha);
        btnEnviar = findViewById(R.id.btnEnviar);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }
        });
    }


    private void cadastrar() {
        final String email = etEmail.getText().toString();
        String senha = etSenha.getText().toString();
        String confirma = etConfirma.getText().toString();
        String erro = "";
        if (email.isEmpty()) {
            erro = "Campo e-mail é obrigatório!";
        } else {
            if (senha.isEmpty() || !senha.equals(confirma)) {
                erro = "Campos de senha são obrigatórios e " +
                        "não podem ter valores diferentes";
            } else {
                final FirebaseAuth autenticacao = FirebaseAuth.getInstance();
                autenticacao.createUserWithEmailAndPassword(email, senha);
                etEmail.setText("");
                etSenha.setText("");
                etConfirma.setText("");

            }
        }
    }
}