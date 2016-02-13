package org.code_freak.com.bunch_of_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class Web_Browser extends AppCompatActivity {



    private WebView wv;
    String url1 = "https://www.facebook.com";
    String url2 = "https://www.twitter.com";
    String url3 = "https://www.google.com";
    String url4;
    EditText etUrlBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_web__browser_layout);
        // getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
        wv = (WebView) findViewById(R.id.webView);
        wv.setWebViewClient(new MyWebViewCLient());


        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url1);
        etUrlBar = (EditText) findViewById(R.id.etUrlBar);
    }
    public void click(View v){

        switch (v.getId()){
            case R.id.btnGoogle:
                wv.loadUrl(url3);
                Toast.makeText(this, "Hang in there Google will open shortly :)", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnFB:
                wv.loadUrl(url1);
                Toast.makeText(this,"Hang in there Facebook will open shortly :)",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnTwitter:
                wv.loadUrl(url2);
                Toast.makeText(this,"Hang in there Twitter will open shortly :)",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnGo:
                url4 = etUrlBar.getText().toString();
                wv.loadUrl(url4);
                Toast.makeText(this,"Hang in there Web Page will open shortly :)",Toast.LENGTH_LONG).show();
                Log.d("web browser","Go clicked");
                break;
        }
    }
    private class MyWebViewCLient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }
    }


}
