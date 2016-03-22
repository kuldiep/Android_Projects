package org.code_freak.com.bunch_of_app;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Greet_User extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextToSpeech mTts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Kuldeep", "onCreate() of GreetUserActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet__user_layout);
        mTts = new TextToSpeech(this, this);
    }

    // when button is clicked this method will be called
    public void GreetUser(View view){
        Log.d("Kuldeep", "button onclick greetUser() of GreetUserActivity");
        EditText etName = (EditText) findViewById(R.id.etName);
        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        if(etName.getText().length() == 0) {
            tvResult.setText("");
            return;
        }
        tvResult.setText(" Namaste, " + etName.getText());
        mTts.speak("Namaste "+etName.getText(),
                TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                null);
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
