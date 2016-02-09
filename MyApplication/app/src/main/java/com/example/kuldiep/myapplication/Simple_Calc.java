package com.example.kuldiep.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

/**
 * Created by Kuldiep on 2/1/2016.
 */
public class Simple_Calc extends Activity {
//    TextView btnRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplecalc_layout);

    }

    public void dosomethingAdd(View view){
        TextView btnRes = (TextView) findViewById(R.id.btnRes);
       // Double num1 = (Double) getText(findViewById(R.id.Simple_Cal_FirstNum).toString());
      //  Double num2 = (Double) getText(findViewById(R.id.Simple_Calc_SecondNum));

        btnRes.setText("not implemented yet");
    }
    public void dosomethingSub(View view){
        TextView btnRes = (TextView) findViewById(R.id.btnRes);

        btnRes.setText("not implemented yet");
    }
    public void dosomethingMul(View view){
        TextView btnRes = (TextView) findViewById(R.id.btnRes);

        btnRes.setText("not implemented yet");
    }
    public void dosomethingDiv(View view){
        TextView btnRes = (TextView) findViewById(R.id.btnRes);

        btnRes.setText("not implemented yet");
    }
    //TextView btnRes = (TextView) findViewById(R.id.btnRes);
}
