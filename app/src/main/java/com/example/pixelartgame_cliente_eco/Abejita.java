package com.example.pixelartgame_cliente_eco;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class Abejita extends AppCompatActivity implements OnMessageListener, View.OnClickListener{

    // Atributos
    private ImageButton botonAccion1;
    private TCPSingleton tcp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abejita);

        // Referencias
        botonAccion1 = findViewById(R.id.botonAccion1);

        botonAccion1.setOnClickListener(this);

        tcp = TCPSingleton.getInstance();
       // tcp.start();

    }

    // Métodos
    @Override
    public void onClick(View v) {
        Gson gson = new Gson();
        Message avanzar = new Message("MOVEE");
        String enviarMovee = gson.toJson(avanzar);
        Log.e("::", enviarMovee);
        tcp.sendMessage(enviarMovee);
    }

    @Override
    public void OnMessage(String msg) {

    }
}