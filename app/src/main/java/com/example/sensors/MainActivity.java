package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static SensorManager sensorManager;
    public static Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*----------------------Sensors ------------*/

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        TextView tv = findViewById(R.id.tv);

        SensorManager sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);

        if (sensor != null) {
            Toast.makeText(this, "Gyroscope Sensor Supported!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Sensor Not Support", Toast.LENGTH_SHORT).show();
        }

        /*--------------- Sensors List ----------------------*/

        List<Sensor> availSensor =
                sensorManager.getSensorList(Sensor.TYPE_ALL);
        String sensorType = "";
        for(Sensor sensor: availSensor){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                sensorType+= sensor.getStringType();
            }
        }
        //Toast.makeText(this, sensorType, Toast.LENGTH_LONG).show();
        tv.setText(sensorType);

    }
}