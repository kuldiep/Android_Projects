package org.code_freak.com.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class User_Personal_Detail extends AppCompatActivity {
    private EditText etUserName;

    public void cancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
    public void saveUserDetails(View view){
        String name = etUserName.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("name",name);
        setResult(RESULT_OK, intent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__personal__detail_layout);
        etUserName = (EditText) findViewById(R.id.etUserName);
    }
}
