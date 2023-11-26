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

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.accelero.databinding.ActivityLightBinding;

public class Light extends AppCompatActivity implements SensorEventListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityLightBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        SensorManager sensor = (SensorManager) getSystemService((SENSOR_SERVICE));

        if(sensor!=null){
            Sensor light = sensor.getDefaultSensor(Sensor.TYPE_LIGHT);

            if(light!=null){
                sensor.registerListener( this, light , SensorManager.SENSOR_DELAY_NORMAL);
            }

        }
        else {
            Toast.makeText( this , "Light Sensor  not detected on this device.", Toast.LENGTH_LONG).show();

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
        if(event.sensor.getType()==Sensor.TYPE_LIGHT){
            ((TextView)findViewById(R.id.lightvalues)).setText("Light Intensity (lx) :\n" +event.values[0] );
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

