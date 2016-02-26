package org.code_freak.com.sensor_project;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Sensor_list extends AppCompatActivity {
    SensorManager sensorManager;
    TextView tvSensorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list_layout);
        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        tvSensorList = (TextView)findViewById(R.id.tvSensorList);

    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorData = new StringBuilder("available resource");
        for (Sensor sensor : sensorList){
            sensorData.append("\n" + sensor.getType() + " " + sensor.getName() + " " + sensor.getPower());

        }
        tvSensorList.setText(sensorData);
    }
}
