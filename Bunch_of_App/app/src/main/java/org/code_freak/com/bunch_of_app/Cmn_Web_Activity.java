package org.code_freak.com.bunch_of_app;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Cmn_Web_Activity extends AppCompatActivity {

    RelativeLayout RL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmn__web_layout);
        Intent intentCommon= getIntent();
        String color_code = intentCommon.getStringExtra(List_View_Color.color_code);
        TextView tvCommon = (TextView)findViewById(R.id.tvCommon);
        tvCommon.setText(color_code+ " selected");
        RL = (RelativeLayout)findViewById(R.id.RL);
        RL.setBackgroundColor(Color.parseColor(color_code));
        /*Integer a = Integer.parseInt(color_code);
        FL = (FrameLayout)findViewById(R.id.FL);
        FL.setBackgroundColor(a);*/
    }

}
