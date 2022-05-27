package com.example.ex1jsontdi201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String r = getLoadJsonFromRaw(R.raw.personne);

        try {
            JSONObject obj = new JSONObject(r);

            Toast.makeText(this, "Nom : "+ obj.getString("nom"), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Prenom : "+ obj.getString("prenom"), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Age : "+ obj.getInt("age"), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getLoadJsonFromRaw(int resId){
        String res = "";

        try {
            InputStream input = getResources().openRawResource(resId);
            int taille = input.available();
            byte[] data = new byte[taille];
            input.read(data);
            res = new String(data);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}