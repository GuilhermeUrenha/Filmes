package com.example.filmes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private final String apikey = "72353a6e";
    private final String template = "http://www.omdbapi.com/?t=star+wars&apikey=72353a6e";
    EditText pesquisa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pesquisa = this.findViewById(R.id.etPesquisa);
        Log.i("alerta","o pai esta on");
    }

    Intent intent;
    String name;

    URL response;
    HttpURLConnection con;

    StringBuilder sb;
    int responseCode;
    String inline;

    JSONObject obj;
    String title;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void Search(View view) {
        name = pesquisa.getText().toString().replace(" ","+");
        try {
            Log.i("alerta","1");
            response = new URL(template);//"http://www.omdbapi.com/?t="+"star+wars"+"&apikey="+apikey);
            Log.i("alerta","1.1");
            con = (HttpURLConnection) response.openConnection();
            con.setRequestMethod("GET");
            Log.i("alerta","1.2");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            try {

                sb = new StringBuilder();
                Log.i("alerta","1.3");

                while ((inline = in.readLine()) != null) {

                    sb.append(inline);
                    sb.append(System.lineSeparator());
                }
                Log.i("alerta","2");
            } finally {
                con.disconnect();
            }
/*
            responseCode = con.getResponseCode();
            if(responseCode != 200){
                throw new RuntimeException("HttpResponseCode: "+responseCode);
            } else {
                Log.i("alerta","3");
                sc = new Scanner(response.openStream());
                while(sc.hasNext()){
                    inline += sc.nextLine();
                }
                obj = new JSONObject(inline);
                title = obj.get("Title").toString();
                Log.i("alerta",title);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        intent = new Intent(this, Filme.class);
        intent.putExtra("test",inline);
        this.startActivity(intent);
    }
}