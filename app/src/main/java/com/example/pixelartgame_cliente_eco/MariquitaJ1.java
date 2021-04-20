package com.example.pixelartgame_cliente_eco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.gson.Gson;

public class MariquitaJ1 extends AppCompatActivity implements View.OnClickListener{
    private ImageButton botonAccion;
    private TCPSingleton tcp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mariquita_j1);

        botonAccion = findViewById(R.id.botonAccion);

        botonAccion.setOnClickListener(this);

        tcp = TCPSingleton.getInstance();
       // tcp.start();

    }

    @Override
    public void onClick(View v) {
        Gson gson = new Gson();
        Message avanzar = new Message("MOVEE");
        String enviarMovee = gson.toJson(avanzar);
        Log.e("::", enviarMovee);
        tcp.sendMessage(enviarMovee);
    }
}