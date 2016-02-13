package org.code_freak.com.bunch_of_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class List_View_Color extends AppCompatActivity {
    public static String color_code;

    ListView listviewcolor;
    ArrayList<String> colorlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__view__color_layout);
        listviewcolor = (ListView) findViewById(R.id.listviewcolor);
        initialize();
        //   color_code = (String)colorlist.get(1);
    }
    public void initialize(){
        colorlist = new ArrayList<String>();
        colorlist.add("Red");
        colorlist.add("Black");
        colorlist.add("Green");
        colorlist.add("Yellow");
        colorlist.add("Violate");
        colorlist.add("Blue");
        colorlist.add("Pink");

    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,colorlist);
        listviewcolor.setAdapter(stringArrayAdapter);
        listviewcolor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                Utils.toastIt(getBaseContext(), tv.getText().toString());
                Intent intent = new Intent(getBaseContext(), Cmn_Web_Activity.class);
                intent.putExtra(color_code, tv.getText());
                startActivity(intent);
            }
        });

    }
}
