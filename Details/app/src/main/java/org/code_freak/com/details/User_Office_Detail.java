package org.code_freak.com.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class User_Office_Detail extends AppCompatActivity {
    private EditText etOfficeName;

    public void Officecancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
    public void saveOfficeDetails(View view){
        String name = etOfficeName.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("name",name);
        setResult(RESULT_OK, intent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__office__detail_lyout);
        etOfficeName = (EditText) findViewById(R.id.etOfficeName);
    }
}
