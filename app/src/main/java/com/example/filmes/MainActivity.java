package com.example.filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private final String apikey = "72353a6e";
    private String search = "http://www.omdbapi.com/?apikey="+apikey+"&";
    EditText pesquisa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pesquisa = this.findViewById(R.id.etPesquisa);
    }

    Intent intent;
    String name;
    URL response;
    HttpURLConnection con;
    Scanner sc;
    int responseCode;
    String inline;
    public void Search(View view){
        name = pesquisa.getText().toString().replace(" ","+");
        try {
            response = new URL("http://www.omdbapi.com/?t="+"star+wars"+"&apikey"+apikey);
            con = (HttpURLConnection) response.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            responseCode = con.getResponseCode();
            if(responseCode != 200){
                throw new RuntimeException("HttpResponseCode: "+responseCode);
            } else {
                sc = new Scanner(response.openStream());
                while(sc.hasNext()){
                    inline += sc.nextLine();
                }
                System.out.println(inline);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        intent = new Intent(this, Filme.class);
        intent.putExtra("test","it was a mistake");
        this.startActivity(intent);
    }
}