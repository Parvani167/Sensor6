package com.example.accelero;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Gravity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);
        SensorManager sensor = (SensorManager) getSystemService((SENSOR_SERVICE));

        if(sensor!=null){
            Sensor gravity = sensor.getDefaultSensor(Sensor.TYPE_GRAVITY);

            if(gravity!=null){
                sensor.registerListener( this, gravity , SensorManager.SENSOR_DELAY_NORMAL);

            }

        }
        else {
            Toast.makeText( this , "Gravity function  not detected on this device.", Toast.LENGTH_LONG).show();

        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_GRAVITY){
            ((TextView)findViewById(R.id.gravityvalues)).setText("X:  " +event.values[0]+ "\nY:  " + event.values[1] + "\nZ:  " + event.values[2]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}