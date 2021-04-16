package com.example.pixelartgame_cliente_eco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements OnMessageListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void OnMessage(String msg) {


    }
}