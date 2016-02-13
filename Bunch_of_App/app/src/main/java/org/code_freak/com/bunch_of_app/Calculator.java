package org.code_freak.com.bunch_of_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    public void Calculation(View view){
        EditText etFirstNum = (EditText) findViewById(R.id.etFirstNum);
        EditText etSecondNum = (EditText) findViewById(R.id.etSecondNum);
        TextView tvResult = (TextView)findViewById(R.id.tvResult);
        Double num1=0.0,num2=0.0;


        try
        {
            num1 = Double.parseDouble(etFirstNum.getText().toString());
        }
        catch (NumberFormatException e)
        {
            tvResult.setText("enter first num");
            return;
        }
        try
        {
            num2 = Double.parseDouble(etSecondNum.getText().toString());
        }
        catch (NumberFormatException e)
        {
            tvResult.setText("enter 2nd num");
            return;
            //System.out.print("cannot be null");

        }

        switch (view.getId()){
            case R.id.btnAdd:
                tvResult.setText("addition is :"+(num1 + num2));
                break;
            case R.id.btnMul:
                tvResult.setText("mul is :"+(num1*num2));
                break;
            case R.id.btnSub:
                tvResult.setText("sub is :"+(num1-num2));
                break;
            case R.id.btnDiv:
                tvResult.setText("div is :"+(num1/num2));
                break;

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_layout);

    }
}
