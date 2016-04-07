package org.code_freak.com.jsonvolley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvJson;

    private ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnClick = (Button) findViewById(R.id.btnClick);
        tvJson = (TextView) findViewById(R.id.tvJson);
    }
    public void GetJson(View view) {


        RequestQueue queue =VolleySingleton.getInstance().requestQueue();
        String url = "https://raw.githubusercontent.com/kuldiep/Android_Projects/master/newjsonfile/newjson.jsonx#";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        tvJson.setText(response.toString());
                        //Toast.makeText(getBaseContext(), "Response is: " + response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getBaseContext(), "That didn't work!", Toast.LENGTH_LONG).show();
            }
        });
        queue.add(stringRequest);
    }
    public void ListAct(View view){
        Intent intent = new Intent(getBaseContext(),ListViewAct.class);
        startActivity(intent);
    }

}
