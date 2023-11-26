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

import com.example.accelero.databinding.ActivityGyroscopescreenBinding;

public class Gyroscopescreen extends AppCompatActivity implements  SensorEventListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityGyroscopescreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscopescreen);

        SensorManager sensor = (SensorManager) getSystemService((SENSOR_SERVICE));

        if(sensor!=null){
            Sensor gyro = sensor.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

            if(gyro!=null){
                sensor.registerListener( this, gyro , SensorManager.SENSOR_DELAY_NORMAL);
            }

        }
        else {
            Toast.makeText( this , "Gyroscope not detected on this device.", Toast.LENGTH_LONG).show();

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
        if(event.sensor.getType()==Sensor.TYPE_GYROSCOPE){
            ((TextView)findViewById(R.id.gyrovalues)).setText("Angular Velocity in X:"+" " +event.values[0]+ "\nAngular Velocity in  Y:" +" "+ event.values[1] + "\nAngular Velocity in Z:" +" "+ event.values[2]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}