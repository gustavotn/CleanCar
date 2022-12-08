package com.example.cleancar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private TextView textViewTemp;
    private TextView textViewHum;
    private TextView textViewResult;
    private SensorManager sensorManager;
    private Sensor tempSensor;
    private Sensor humSensor;
    private Float result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);

        textViewTemp = findViewById(R.id.tvTemp);
        textViewHum = findViewById(R.id.tvHum);
        textViewResult = findViewById(R.id.tvResult);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY) != null) {
            humSensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        }

        sensorManager.registerListener(new SensorHum(), humSensor, SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(new SensorTemper(), tempSensor, SensorManager.SENSOR_DELAY_UI);

        //result =  humSensor.values[0] * tempSensor.values[0];

        //textViewResult.setText(result.toString());

    }

    class SensorTemper implements SensorEventListener {
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        public void onSensorChanged(SensorEvent event) {
            float temperatura = event.values[0];
            textViewTemp.setText(String.valueOf(temperatura));

        }
    }

    class SensorHum implements SensorEventListener {
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        public void onSensorChanged(SensorEvent event) {
            float hum = event.values[0];
            textViewHum.setText(String.valueOf(hum));
        }
    }

    public void OnClickAgendar(View view) {
        Intent intent_Agendar = new Intent(this, Agendar.class);
        startActivity(intent_Agendar);
    }

    public void OnClickAgendamentos(View view) {
        Intent intent_Agendamentos = new Intent(this, Agendamentos.class);
        startActivity(intent_Agendamentos);
    }

}