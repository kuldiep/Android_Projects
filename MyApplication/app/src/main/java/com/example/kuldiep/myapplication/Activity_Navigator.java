package com.example.kuldiep.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;


public class Activity_Navigator extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__navigator_layout);
    }
    public static final String NEWS_TYPE = "newstype";
    public void Navigate(View view){
        switch (view.getId())
        {
            case R.id.btnBrowser:
                String url = "https://www.Facebook.com";
                Intent intentBrowser = new Intent(Intent.ACTION_VIEW);
                intentBrowser.setData(Uri.parse(url));
                startActivity(intentBrowser);
                Toast.makeText(getBaseContext(),"Browser pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnMusic:
                Intent intentMusic = new Intent("android.intent.action.MUSIC_PLAYER");
                startActivity(intentMusic);
                //Toast toast = new Toast() ;
                Toast.makeText(getBaseContext(), "Music pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCall:
                String phone = "+34666777888";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intentCall);
                Toast.makeText(getBaseContext(), "Call Pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnDialer:
                Intent intentDialer = new Intent(Intent.ACTION_DIAL);
                intentDialer.setData(Uri.parse("tel:8154888831"));
                startActivity(intentDialer);
                Toast.makeText(getBaseContext(), "Dialer Pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCamera:
                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intentCamera);
                Toast.makeText(getBaseContext(), "Camera Pressed", Toast.LENGTH_LONG).show();
                break;
            case  R.id.btnWhatsApp:
                Intent intentWhatsapp = new Intent();
                intentWhatsapp.setAction(Intent.ACTION_SEND);
                intentWhatsapp.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                intentWhatsapp.setType("text/plain");
                intentWhatsapp.setPackage("com.whatsapp");
                startActivity(intentWhatsapp);
                Toast.makeText(getBaseContext(), "Whatsapp pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnFelight:
                Intent intentFelight = new Intent(getBaseContext(), Common_Activity_News.class);
                intentFelight.putExtra(NEWS_TYPE, "Felight");
                startActivity(intentFelight);
                Toast.makeText(getBaseContext(), "Felight Pressed", Toast.LENGTH_LONG).show();
                Toast toast = new Toast(this);

                toast.setGravity(5,100,0);
                break;
            case R.id.btnGoogle:
                Intent intentGoogle = new Intent(getBaseContext(),Common_Activity_News.class);
                intentGoogle.putExtra(NEWS_TYPE,"Google");
                startActivity(intentGoogle);
                Toast.makeText(getBaseContext(), "Google pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCalc:
                Intent intent = new Intent(this,Calculator.class);
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Calc Pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnGreet:
                Intent intent2 = new Intent(this,Greet_User.class);
                startActivity(intent2);
                Toast.makeText(getBaseContext(), "Greet Pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnRegister:
                Intent intent3 = new Intent(this,User_Activity_Registration.class);
                startActivity(intent3);
                Toast.makeText(getBaseContext(), "Register Pressed", Toast.LENGTH_LONG).show();
                break;
        }

    }
}
