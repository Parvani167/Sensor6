package com.example.accelero;

import static android.app.ProgressDialog.show;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.accelero.databinding.ActivityMainBinding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class homepage extends AppCompatActivity  {
    private Button button;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, Accelerometerscreen.class);
                startActivity(intent);
            }

        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, Gyroscopescreen.class);
                startActivity(intent);
            }


        });

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent =new Intent(homepage.this , Light.class);
                startActivity(intent);
            }

        });

        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent =new Intent(homepage.this , Pressurescreen.class);
                startActivity(intent);
            }

        });

        Button button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent =new Intent(homepage.this , Geomagneticscreen.class);
                startActivity(intent);
            }

        });

        Button button6 = (Button)findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent =new Intent(homepage.this , Resources.class);
                startActivity(intent);
            }

        });

        Button button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent =new Intent(homepage.this , Gravity.class);
                startActivity(intent);
            }

        });


    }}

    











