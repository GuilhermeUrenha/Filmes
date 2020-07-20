package com.example.filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Filme extends AppCompatActivity implements AsyncResponse {

    Intent intent;
    TextView tvFilme;
    EditText etDir, etAtr, etAno, etGen, etFxe, etLan, etDur, etSin, etPas, etLng, etPrm;
    JsonParser jsonParser = new JsonParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme);

        tvFilme = this.findViewById(R.id.tvFilme);
        intent = getIntent();
        String apiUrl = intent.getStringExtra("url");

        etDir = this.findViewById(R.id.etDir);
        etAtr = this.findViewById(R.id.etAtr);
        etAno = this.findViewById(R.id.etAno);
        etGen = this.findViewById(R.id.etGen);
        etFxe = this.findViewById(R.id.etFxe);
        etLan = this.findViewById(R.id.etLan);
        etDur = this.findViewById(R.id.etDur);
        etSin = this.findViewById(R.id.etSin);
        etPas = this.findViewById(R.id.etPas);
        etLng = this.findViewById(R.id.etLng);
        etPrm = this.findViewById(R.id.etPrm);

        jsonParser.delegate = this;
        jsonParser.execute(apiUrl);
    }

    @Override
    public void processFinished(JSONObject output) {
        String title = "",
                director = "",
                actor = "",
                year = "",
                genre = "",
                line = "",
                released = "",
                duration = "",
                synopsis = "",
                country = "",
                language = "",
                awards = "";
        try {
            title = output.get("title").toString();
            director = output.get("director").toString();
            actor = output.get("actors").toString();
            year = output.get("date").toString();
            genre = output.get("genre").toString();
            line = output.get("rated").toString();
            released = output.get("released").toString();
            duration = output.get("runtime").toString();
            synopsis = output.get("plot").toString();
            country = output.get("country").toString();
            language = output.get("language").toString();
            awards = output.get("awards").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        tvFilme.setText(title);
        etDir.setText(director);
        etAtr.setText(actor);
        etAno.setText(year);
        etGen.setText(genre);
        etFxe.setText(line);
        etLan.setText(released);
        etDur.setText(duration);
        etSin.setText(synopsis);
        etPas.setText(country);
        etLng.setText(language);
        etPrm.setText(awards);
    }
}















/*        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if(inputManager != null){
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if(connMgr != null){
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        if(networkInfo != null && networkInfo.isConnected() && name.length() != 0){
            Bundle bundle = new Bundle();
            bundle.putString("res", name);
        }
        StringBuilder builder = null;
        try {
            String template = "http://www.omdbapi.com/?t=star+wars&apikey=72353a6e";
            URL url = new URL(template);
            request = (HttpURLConnection) url.openConnection();
            request.setRequestMethod("GET");
            request.connect();
            InputStream input = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
            builder = new StringBuilder();
            String inline;
            while ((inline = reader.readLine()) != null) {
                builder.append(inline);
                builder.append(System.lineSeparator());
            }

            if(builder.length() == 0){ return; }
            res = builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(request != null){
                request.disconnect();
            }
            if(reader != null){
                try{
                    reader.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }*/