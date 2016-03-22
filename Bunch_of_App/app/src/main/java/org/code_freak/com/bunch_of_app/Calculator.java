package org.code_freak.com.bunch_of_app;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Calculator extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextToSpeech mTts;
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
                mTts.speak("Result is " + tvResult.getText(),
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
                break;
            case R.id.btnMul:
                tvResult.setText("mul is :"+(num1*num2));
                mTts.speak("Result is " + tvResult.getText(),
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
                break;
            case R.id.btnSub:
                tvResult.setText("sub is :"+(num1-num2));
                mTts.speak("Result is " + tvResult.getText(),
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
                break;
            case R.id.btnDiv:
                tvResult.setText("div is :"+(num1/num2));
                mTts.speak("Result is " + tvResult.getText(),
                        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                        null);
                break;

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_layout);
        mTts = new TextToSpeech(this, this);
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
  //              Log.e(NavigatorActivity.TAG, "Language is not available.");
            }
        } else {
            // Initialization failed.
//            Log.e(NavigatorActivity.TAG, "Could not initialize TextToSpeech.");
        }

    }
}
