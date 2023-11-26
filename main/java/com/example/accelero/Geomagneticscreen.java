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

import com.example.accelero.databinding.ActivityGeomagneticscreenBinding;

public class Geomagneticscreen extends AppCompatActivity implements SensorEventListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityGeomagneticscreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geomagneticscreen);

        SensorManager sensor = (SensorManager) getSystemService((SENSOR_SERVICE));

        if(sensor!=null){
            Sensor magnet = sensor.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

            if(magnet!=null){
                sensor.registerListener( this, magnet , SensorManager.SENSOR_DELAY_NORMAL);
            }

        }
        else {
            Toast.makeText( this , "Magnetometer not detected on this device.", Toast.LENGTH_LONG).show();

        }


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){
            ((TextView)findViewById(R.id.fieldvalues)).setText("Magnetic Field of the Earth is : "+event.values[0]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
