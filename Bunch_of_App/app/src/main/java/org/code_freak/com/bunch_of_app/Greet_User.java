package org.code_freak.com.bunch_of_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Greet_User extends AppCompatActivity {
    public void GreetUser(View view){
        EditText etName = (EditText) findViewById(R.id.etName);
        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult.setText("Namste "+etName.getText());

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet__user_layout);
    }
}
