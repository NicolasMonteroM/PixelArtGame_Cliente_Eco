package com.example.pixelartgame_cliente_eco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements OnMessageListener {
    private ImageButton botonConect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonConect = findViewById(R.id.botonConect);
        botonConect.setOnClickListener(
                v -> {

                        Intent i = new Intent(this, MariquitaJ1.class);
                        startActivity(i);

                }
        );
    }

    @Override
    public void OnMessage(String msg) {


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}