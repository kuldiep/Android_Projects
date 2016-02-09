package com.example.kuldiep.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Kuldiep on 2/1/2016.
 */
public class Greet_User extends Activity {
    public void GreetUser(View view){
        EditText etName = (EditText) findViewById(R.id.etName);
        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult.setText("Hello "+etName.getText());
       // btnResult.setText("Namaste"+getText());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greetuser_layout);
    }
}
