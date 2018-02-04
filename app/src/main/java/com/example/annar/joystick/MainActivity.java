package com.example.annar.joystick;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BluetoothSocket mmSocket;
    BluetoothDevice mmDevice = null;

    final byte delimiter = 33;
    int readBufferPosition = 0;

    /**
     * A function that will send info to the raspberry pi (the android will be acting as a "client" here). If not connected, the method will
     * create a RFCOMM socket, get a writeable stream, and push the message through the socket
     * @param msg2send is the message to be sent to the raspberry pi
     */
    public void sendBtMsg(String msg2send){
        //UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //Standard SerialPortService ID
        UUID uuid = UUID.fromString("94f39d29-7d6d-437d-973b-fba39e49d4ee"); //Standard SerialPortService ID
        //TODO UUID needs to match with the number from Python script in raspberry Pi (line 46 of website ref)

        final TextView con = (TextView)findViewById(R.id.checkConnection); // for debugging
        try {

            mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
            if (!mmSocket.isConnected()){
                mmSocket.connect();
                con.setText("Connected");
            }

            String msg = msg2send;
            OutputStream mmOutputStream = mmSocket.getOutputStream();
            mmOutputStream.write(msg.getBytes());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text= (TextView)findViewById(R.id.text);
        final TextView text2=(TextView)findViewById(R.id.text2);
        Button left = (Button) findViewById(R.id.Left);
        Button right = (Button) findViewById(R.id.Right);

        left.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                sendBtMsg("Left");
                text.setText("SAF");

            }
        });

        right.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                sendBtMsg("Right");
                text2.setText("whats good in the hood?");
            }
        });
    }}


