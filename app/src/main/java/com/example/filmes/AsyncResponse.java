package com.example.filmes;

import android.graphics.Bitmap;

import org.json.JSONObject;

public interface AsyncResponse {
    void processFinished(JSONObject jsonObject);
}
