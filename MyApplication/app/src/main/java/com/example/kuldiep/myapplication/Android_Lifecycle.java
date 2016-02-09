package com.example.kuldiep.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Kuldiep on 2/2/2016.
 */
public class Android_Lifecycle extends Activity {
    public static final String TAG ="life cycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"onCreate method called");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        Log.i(TAG,"onStart method called");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.i(TAG,"onPause method called");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.i(TAG,"onResume method called");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.i(TAG,"onStop method called");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG,"onRestart method called");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG,"onDestroy method called");
        super.onDestroy();
    }
}
