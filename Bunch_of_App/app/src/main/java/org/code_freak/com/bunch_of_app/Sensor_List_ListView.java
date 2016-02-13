package org.code_freak.com.bunch_of_app;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Sensor_List_ListView extends AppCompatActivity {

    ListView listView;
    SensorManager sensorManager;
    List<Sensor> arraySensor;
    Sensor sensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor__list__list_view_layout);
        listView = (ListView)findViewById(R.id.listView);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        initialize();
    }
    public void initialize(){
        arraySensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

    }


    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter<Sensor> sensorArrayAdapter = new ArrayAdapter<Sensor>(this,android.R.layout.simple_list_item_1,arraySensor);
        listView.setAdapter(sensorArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                //Toast.makeText(getBaseContext(),"selected sensor is"+sensor.getName()+""+sensor.getType(),Toast.LENGTH_LONG).show();
                Utils.toastIt(getBaseContext(), tv.getText().toString());
            }
        });

    }
}
