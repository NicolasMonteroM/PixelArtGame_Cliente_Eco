package com.example.pixelartgame_cliente_eco;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPSingleton extends Thread {

    // Patron Singleton

    private static TCPSingleton instance; //Única Instancia

    public static TCPSingleton getInstance() { //Método estático
        if (instance == null) {
            instance = new TCPSingleton();
            instance.start();
        }
        return instance;
    }

    private TCPSingleton(){ //Constructor singleton
    }

    private  Socket socket;
    private BufferedWriter bwriter;

    // Patrón observer

    //private OnMessageListener observer;

    //public void setObserver(OnMessageListener observer) {
    //    this.observer = observer;
    //}

    @Override
    public void run() {
        try {
            // <–– PC address -->
            socket = new Socket("10.0.2.2", 8000); //IP del emulador en el puerto 8000
            Log.e("::", "entrando a socket");
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);

            bwriter = new BufferedWriter(osw);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) { // Envío de mensaje al server
        Log.e(":::",msg);
        new Thread(() -> {
            try {
                Log.e("::", msg);
                bwriter.write(msg + "\n"); // Mensaje con salto de linea
                bwriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}