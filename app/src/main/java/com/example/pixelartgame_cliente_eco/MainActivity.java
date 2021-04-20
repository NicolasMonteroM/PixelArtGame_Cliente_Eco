package com.example.pixelartgame_cliente_eco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements OnMessageListener {

    // Atributos
    private ImageButton botonConect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referecias
        botonConect = findViewById(R.id.botonConect);

        // Cambio de pantalla con click
        botonConect.setOnClickListener(
                v -> {
                        Intent i = new Intent(this, Mariquita.class);
                        startActivity(i);
                }
        );
    }

    // Métodos
    @Override
    public void OnMessage(String msg) {


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}