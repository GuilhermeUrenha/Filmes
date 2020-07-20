package com.example.filmes;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText pesquisa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pesquisa = this.findViewById(R.id.etPesquisa);
    }

    Intent intent;
    String template = "http://www.omdbapi.com/?t=";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void Search(View view) {
        String search = pesquisa.getText().toString().replace(" ","+");
        String apikey = "72353a6e";
        String res = template + search +"&apikey="+ apikey;

        intent = new Intent(this, Filme.class);
        intent.putExtra("url", res);
        this.startActivity(intent);
    }
}
