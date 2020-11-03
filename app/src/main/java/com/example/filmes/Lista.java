package com.example.filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {

    ListView listViewFilmes;
    BancoDados db = new BancoDados(this);
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        intent = new Intent(this, FilmeCad.class);


        listViewFilmes = (ListView) findViewById(R.id.listViewFilmes);
        listarFilmes();

        listViewFilmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String conteudo = (String)listViewFilmes.getItemAtPosition(position);
                //Toast.makeText(MainActivity.this, "Select: "+ conteudo, Toast.LENGTH_LONG).show();
                String codigo = conteudo.substring(0, conteudo.indexOf("-"));
                intent.putExtra("codigo",codigo);
                startActivity(intent);
            }
        });
    }

    public void listarFilmes(){
        List<Filme> filmes = db.listaTodosFilmes();

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(Lista.this, android.R.layout.simple_list_item_1, arrayList);
        listViewFilmes.setAdapter(adapter);

        for(Filme f : filmes){
            arrayList.add(f.getCodigo() +"-"+ f.getTitulo());
            adapter.notifyDataSetChanged();
        }
    }
}