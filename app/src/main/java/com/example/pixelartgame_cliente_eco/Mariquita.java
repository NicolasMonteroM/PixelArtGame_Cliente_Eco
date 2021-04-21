package com.example.pixelartgame_cliente_eco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class Mariquita extends AppCompatActivity implements OnMessageListener, View.OnClickListener {
    // Atributos
    private ImageButton botonAccion1;
    private TCPSingleton tcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mariquita);

        // Referencias
        botonAccion1 = findViewById(R.id.botonAccion1);

        botonAccion1.setOnClickListener(this);

        tcp = TCPSingleton.getInstance();
        tcp.setObserver(this);
       // tcp.start();

    }

    // Métodos
    @Override
    public void onClick(View v) {
        //serialización gson
        Gson gson = new Gson();
        Message avanzar = new Message("MOVEE");
        String enviarMovee = gson.toJson(avanzar);
        Log.e("::", enviarMovee);
        tcp.sendMessage(enviarMovee);
    }

    @Override
    public void OnMessage(String msg) {
        runOnUiThread(
                () -> {
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                }
        );
    }
}