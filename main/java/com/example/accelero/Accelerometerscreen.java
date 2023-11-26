package com.example.accelero;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.accelero.databinding.AccelerometerscreenBinding;

public class Accelerometerscreen extends AppCompatActivity implements SensorEventListener {

    private AppBarConfiguration appBarConfiguration;
    private AccelerometerscreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accelerometerscreen);

        SensorManager sensor = (SensorManager) getSystemService((SENSOR_SERVICE));

        if(sensor!=null){
            Sensor accelero = sensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            if(accelero!=null){
                sensor.registerListener(this , accelero , SensorManager.SENSOR_DELAY_NORMAL);
            }

        }
        else {
            Toast.makeText( this , "Accelerometer not detected on this device.", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            ((TextView)findViewById(R.id.txtValues)).setText("X : "+event.values[0]+"\nY : " + event.values[1] + "\nZ : " + event.values[2]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}