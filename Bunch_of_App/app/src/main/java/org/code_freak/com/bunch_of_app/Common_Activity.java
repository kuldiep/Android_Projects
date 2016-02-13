package org.code_freak.com.bunch_of_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Common_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_layout);
        Intent intentCommon = getIntent();
        String newstype = intentCommon.getStringExtra(Activity_Navigator.NEWS_TYPE);
        TextView tvNews = (TextView) findViewById(R.id.tvNews);
        tvNews.setText(newstype + "news will be displayed");
    }
}
