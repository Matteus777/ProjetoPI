package com.tiqueliro.projetopi;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {
    private ListView lvProdutos;
    private List<Produto> listaDeProdutos;
    private AdapterProduto adapter;

    FirebaseDatabase database;
    DatabaseReference reference;
    Query queryref;
    ChildEventListener childeventlistener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        lvProdutos = (ListView) findViewById(R.id.lvProdutos);
        listaDeProdutos = new ArrayList<>();
      adapter = new AdapterProduto(ListaActivity.this,listaDeProdutos);
        lvProdutos.setAdapter(adapter);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListaActivity.this,
                        CadastroActivity.class);
                startActivity( i );
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        listaDeProdutos.clear();
        queryref = reference.child("produtos").orderByChild("nome");

        childeventlistener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Produto p = new Produto();
                p.setId(dataSnapshot.getKey());
                p.setNome(dataSnapshot.child("nome").getValue(String.class));


                listaDeProdutos.add(p);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        reference.addChildEventListener(childeventlistener);

    }

    @Override
    protected void onStop() {
        super.onStop();
        reference.removeEventListener(childeventlistener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Cadastrar Categoria");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.toString().equals("Cadastrar Categoria")){
            Intent b = new Intent(ListaActivity.this,
                    CadastroCategoria.class);
            startActivity( b );
        }


        return super.onOptionsItemSelected(item);
    }
}
