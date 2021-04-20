package com.example.pixelartgame_cliente_eco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;

public class Mariquita extends AppCompatActivity implements OnMessageListener, View.OnClickListener{
    // Atributos
    private ImageButton botonAccion1;
    private TCPSingleton tcp;
    private TextView distanceText;
    private int x=250;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mariquita);

        // Referencias
        botonAccion1 = findViewById(R.id.botonAccion1);
        distanceText = findViewById(R.id.distanceText);

        botonAccion1.setOnClickListener(this);

        tcp = TCPSingleton.getInstance();
       // tcp.start();
        distanceText.setText(x + "km");
    }

    // Métodos
    @Override
    public void onClick(View v) {
        Gson gson = new Gson();
        Message avanzar = new Message("MOVEE");
        String enviarMovee = gson.toJson(avanzar);
        Log.e("::", enviarMovee);
        tcp.sendMessage(enviarMovee);
        x=x-5;
    }

    @Override
    public void OnMessage(String msg) {

    }
}