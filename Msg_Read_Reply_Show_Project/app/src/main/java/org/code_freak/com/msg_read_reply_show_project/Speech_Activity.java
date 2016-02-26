package org.code_freak.com.msg_read_reply_show_project;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Speech_Activity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    String mymsg;
    private TextToSpeech mTts;
    private Button btnSpeech;
    private EditText etMsg;
private Button btnMessage;
    //private TextView tvMsg;
    String msgtype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_layout);
        //tvMsg = (TextView)findViewById(R.id.tvMsg);
        Intent intent = getIntent();
        msgtype = intent.getStringExtra(SmsActivity.MSG_TYPE);
        etMsg = (EditText)findViewById(R.id.etMsg);

    }
public void GetMessage(View view){
    etMsg.setText(msgtype);
}

    public void Speak(View view){
        try {


            mTts.speak(msgtype.toString(),
                    TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                    null);
        }catch (Exception ex){
            Toast.makeText(getBaseContext(),"null",Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public void onDestroy() {
        // Don't forget to shutdown!
        if (mTts != null) {
            mTts.stop();
            mTts.shutdown();
        }
        super.onDestroy();
    }
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = mTts.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Lanuage data is missing or the language is not supported.
                Log.e("Kuldeep", "Language is not available.");
            }
        } else {
            // Initialization failed.
            Log.e("Kuldeep", "Could not initialize TextToSpeech.");
        }
    }

}
