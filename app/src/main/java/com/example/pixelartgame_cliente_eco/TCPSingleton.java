package com.example.pixelartgame_cliente_eco;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPSingleton extends Thread {

    private static TCPSingleton instance;

    public static TCPSingleton getInstance() {
        if (instance == null) {
            instance = new TCPSingleton();
            instance.start();
        }
        return instance;
    }

    private TCPSingleton(){
    }

    private  Socket socket;
    private BufferedWriter bwriter;
    //private OnMessageListener observer;

    //public void setObserver(OnMessageListener observer) {
    //    this.observer = observer;
    //}

    @Override
    public void run() {
        try {
            // <–– PC address -->
            socket = new Socket("192.168.1.14", 8000);
            Log.e("::", "entrando a socket");
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);

            bwriter = new BufferedWriter(osw);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        Log.e(":::",msg);
        new Thread(() -> {
            try {
                Log.e("::", msg);
                bwriter.write(msg + "\n");
                bwriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}