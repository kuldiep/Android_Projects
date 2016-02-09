package com.example.kuldiep.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Common_Activity_News extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common__activity__news_layout);

        Intent intentCommon = getIntent();
        String newstype = intentCommon.getStringExtra(Activity_Navigator.NEWS_TYPE);
        TextView tvNews = (TextView) findViewById(R.id.tvNews);
        tvNews.setText(newstype+"news will be displayed");
    }
}
