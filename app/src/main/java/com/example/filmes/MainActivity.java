package com.example.filmes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText pesquisa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pesquisa = (EditText)findViewById(R.id.etPesquisa);
    }

    public void Search(View view) {
        try {
            String search = pesquisa.getText().toString().replace(" ", "+");
            String res = "https://www.omdbapi.com/?t=" + search + "&apikey=72353a6e";

            Intent intent = new Intent(this, Result.class);
            intent.putExtra("url", res);
            startActivity(intent);
        }
        catch(Exception e){
            Log.e("erro", String.valueOf(e));
        }
    }

    public void Lista(View view){
        Intent intent = new Intent(this, Lista.class);
        startActivity(intent);
    }
}
