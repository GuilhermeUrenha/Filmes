package com.example.filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class Result extends AppCompatActivity implements AsyncResponse {

    TextView tvFilme;
    TextView etDir, etAtr, etGen, etFxe, etLan, etDur, etSin, etPas, etLng, etPrm;
    Button btnCadastrar;
    JSONParse jsonParser = new JSONParse();
    BancoDados db = new BancoDados(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvFilme = (TextView)findViewById(R.id.tvFilme);
        Intent intent = getIntent();
        String apiUrl = intent.getStringExtra("url");
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        etDir = (TextView)findViewById(R.id.etDir);
        etAtr = (TextView)findViewById(R.id.etAtr);
        etGen = (TextView)findViewById(R.id.etGen);
        etFxe = (TextView)findViewById(R.id.etFxe);
        etLan = (TextView)findViewById(R.id.etLan);
        etDur = (TextView)findViewById(R.id.etDur);
        etSin = (TextView)findViewById(R.id.etSin);
        etPas = (TextView)findViewById(R.id.etPas);
        etLng = (TextView)findViewById(R.id.etLng);
        etPrm = (TextView)findViewById(R.id.etPrm);

        jsonParser.delegate = this;
        jsonParser.execute(apiUrl);
    }

    @Override
    public void processFinished(JSONObject output) {
        try{
            Log.v("resultado", output.get("Title").toString());
        } catch (Exception e){
            e.printStackTrace();
        }
        String title = "Sem Título",
                director = "Sem Diretor",
                actor = "Sem Atores",
                genre = "Sem Gêneros",
                line = "Sem Faixa Etária",
                released = "Sem Data de Lançamento",
                duration = "Sem Duração",
                synopsis = "Sem Sinopse",
                country = "Sem País",
                language = "Sem Língua",
                awards = "Sem Prêmios";
        try {
            title = output.get("Title").toString();
            director = output.get("Director").toString();
            actor = output.get("Actors").toString();
            genre = output.get("Genre").toString();
            line = output.get("Rated").toString();
            released = output.get("Released").toString();
            duration = output.get("Runtime").toString();
            synopsis = output.get("Plot").toString();
            country = output.get("Country").toString();
            language = output.get("Language").toString();
            awards = output.get("Awards").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tvFilme.setText(title);
        etDir.setText(director);
        etAtr.setText(actor);
        etGen.setText(genre);
        etFxe.setText(line);
        etLan.setText(released);
        etDur.setText(duration);
        etSin.setText(synopsis);
        etPas.setText(country);
        etLng.setText(language);
        etPrm.setText(awards);
    }

    public void Cadastrar(View v) {
        String titulo = tvFilme.getText().toString();
        String diretor = etDir.getText().toString();
        String atores = etAtr.getText().toString();
        String genero = etGen.getText().toString();
        String faixa = etFxe.getText().toString();
        String lancamento = etLan.getText().toString();
        String duracao = etDur.getText().toString();
        String sinopse = etSin.getText().toString();
        String pais = etPas.getText().toString();
        String lingua = etLng.getText().toString();
        String premios = etPrm.getText().toString();

        // insert
        db.addFilme(new Filme(titulo, diretor, atores, genero, faixa, lancamento, duracao, sinopse, pais, lingua, premios));
        Toast.makeText(Result.this, "Filme cadastrado com sucesso.", Toast.LENGTH_LONG).show();
    }
}
