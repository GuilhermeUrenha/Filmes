package com.example.filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class FilmeCad extends AppCompatActivity {

    BancoDados db = new BancoDados(this);
    EditText txCodigo, txTitulo, txAtores, txGenero, txFaixa, txLancamento, txDuracao, txSinopse, txPais, txLingua, txPremios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_cad);
        txCodigo = (EditText)findViewById(R.id.txCodigo);
        txTitulo = (EditText)findViewById(R.id.txTitulo);
        txAtores = (EditText)findViewById(R.id.txAtores);
        txGenero = (EditText)findViewById(R.id.txGenero);
        txFaixa = (EditText)findViewById(R.id.txFaixa);
        txLancamento = (EditText)findViewById(R.id.txLancamento);
        txDuracao = (EditText)findViewById(R.id.txDuracao);
        txSinopse = (EditText)findViewById(R.id.txSinopse);
        txPais = (EditText)findViewById(R.id.txPais);
        txLingua = (EditText)findViewById(R.id.txLingua);
        txPremios = (EditText)findViewById(R.id.txPremios);

        Intent intent = getIntent();
        String codigo = intent.getStringExtra("codigo");
        assert codigo != null;
        Filme filme = db.selecionarFilme(Integer.parseInt(codigo));

        txCodigo.setText(codigo);
        txTitulo.setText(filme.getTitulo());
        txAtores.setText(filme.getAtores());
        txGenero.setText(filme.getGenero());
        txFaixa.setText(filme.getFaixa());
        txLancamento.setText(filme.getLancamento());
        txDuracao.setText(filme.getDuracao());
        txSinopse.setText(filme.getSinopse());
        txPais.setText(filme.getPais());
        txLingua.setText(filme.getLingua());
        txPremios.setText(filme.getPremios());
    }

    public void Excluir(View v) {
        String codigo = txCodigo.getText().toString();
        Filme filme = new Filme();
        filme.setCodigo(Integer.parseInt(codigo));
        db.apagarFilme(filme);

        Toast.makeText(FilmeCad.this, "Cliente excluido com sucesso.", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, Lista.class);
        //escondeTeclado();
        startActivity(intent);
    }

//    void escondeTeclado(){
//        InputMethodManager imm = (InputMethodManager) this.getSystemService(Service.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(txTitulo.getWindowToken(), 0);
//    }
}