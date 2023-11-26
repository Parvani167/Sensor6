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

import com.example.accelero.databinding.ActivityPressurescreenBinding;

public class Pressurescreen extends AppCompatActivity implements SensorEventListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityPressurescreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressurescreen);

        SensorManager sensor = (SensorManager) getSystemService((SENSOR_SERVICE));

        if (sensor != null) {
            Sensor atm = sensor.getDefaultSensor(Sensor.TYPE_PRESSURE);

            if (atm != null) {
                sensor.registerListener(this, atm, SensorManager.SENSOR_DELAY_NORMAL);
            }

        } else {
            Toast.makeText(this, "Accelerometer not detected on this device.", Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_PRESSURE){
            ((TextView)findViewById(R.id.pressurevalues)).setText("Atmospheric Pressure of this room is:\n "+event.values[0]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    }


