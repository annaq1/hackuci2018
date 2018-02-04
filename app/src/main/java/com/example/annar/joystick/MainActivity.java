package com.example.annar.joystick;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text= (TextView)findViewById(R.id.text);
        final TextView text2=(TextView)findViewById(R.id.text2);
        Button btn1 = (Button) findViewById(R.id.Left);
        Button btn2 = (Button) findViewById(R.id.Right);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                text.setText("SAF");

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                text2.setText("whats good in the hood?");
            }
        });
    }}


