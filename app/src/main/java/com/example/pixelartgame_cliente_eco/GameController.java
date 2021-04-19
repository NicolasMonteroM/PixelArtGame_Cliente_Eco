package com.example.pixelartgame_cliente_eco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

public class GameController extends AppCompatActivity implements OnMessageListener, View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_controller);
    }

    @Override
    public void onClick(View v) {

        Gson gson = new Gson();

        //cambio c:

       /* case R.id.upBtn:
        Message upStartMsg = new Message("FLYYY");
        String upStartJson = gson.toJson(upStartMsg);
        tcpSingleton.sendMessage(upStartJson);*/

    }

    @Override
    public void OnMessage(String msg) {

    }
}