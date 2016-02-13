package org.code_freak.com.bunch_of_app;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Activity_Navigator extends AppCompatActivity {
    public static final String NEWS_TYPE = "newstype";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__navigator_layout);
    }
    public void Open_Activity(View view){

        switch (view.getId()){
            case R.id.btnCalc:
                Intent intent = new Intent(this,Calculator.class);
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Calc Pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnBrowser:
                String url = "https://www.Facebook.com";
                Intent intentBrowser = new Intent(Intent.ACTION_VIEW);
                intentBrowser.setData(Uri.parse(url));
                startActivity(intentBrowser);
                Toast.makeText(getBaseContext(),"Browser pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCamera:
                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intentCamera);
                Toast.makeText(getBaseContext(), "Camera Pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCall:
                String phone = "+34666777888";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intentCall);
                Toast.makeText(getBaseContext(), "Call Pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnDial:
                Intent intentDialer = new Intent(Intent.ACTION_DIAL);
                intentDialer.setData(Uri.parse("tel:8154888831"));
                startActivity(intentDialer);
                Toast.makeText(getBaseContext(), "Dialer Pressed", Toast.LENGTH_LONG).show();
                break;
            case  R.id.btnFelight:
                Intent intentFelight = new Intent(getBaseContext(),Common_Activity.class);
                intentFelight.putExtra(NEWS_TYPE, "Felight");
                startActivity(intentFelight);
                Toast.makeText(getBaseContext(), "Felight Pressed", Toast.LENGTH_LONG).show();
                Toast toast = new Toast(this);
                toast.setGravity(5, 100, 0);
                break;
            case  R.id.btnGoogle:
                Intent intentGoogle = new Intent(getBaseContext(),Common_Activity.class);
                intentGoogle.putExtra(NEWS_TYPE, "Google");
                startActivity(intentGoogle);
                Toast.makeText(getBaseContext(), "Google pressed", Toast.LENGTH_LONG).show();
                break;

            case R.id.btnGreet:
                Intent intent2 = new Intent(this,Greet_User.class);
                startActivity(intent2);
                Toast.makeText(getBaseContext(), "Greet Pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnRegister:

                break;
            case R.id.btnWhatsApp:
                Intent intentWhatsapp = new Intent();
                intentWhatsapp.setAction(Intent.ACTION_SEND);
                intentWhatsapp.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                intentWhatsapp.setType("text/plain");
                intentWhatsapp.setPackage("com.whatsapp");
                startActivity(intentWhatsapp);
                Toast.makeText(getBaseContext(), "Whatsapp pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnAlgoBench:
                Intent intentAlgo = new Intent(this,Algorithm_Benchmark.class);
                startActivity(intentAlgo);
                Toast.makeText(getBaseContext(), "Algorithm Benchmarking pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnGetImage:
                Intent intentGetImage = new Intent(this,Get_Image.class);
                startActivity(intentGetImage);
                Toast.makeText(getBaseContext(), "Get Imege pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnGetContact:
                Intent intentContact = new Intent(this,Get_Contact.class);
                startActivity(intentContact);
                Toast.makeText(getBaseContext(), "Get Contact pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCostomBrowser:
                Intent intentWeb = new Intent(this,Web_Browser.class);
                startActivity(intentWeb);
                Toast.makeText(getBaseContext(), "Custom Browser pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnSensorDemo:
                Intent intentSensor = new Intent(this,Sensor_List.class);
                startActivity(intentSensor);
                Toast.makeText(getBaseContext(), "Sensor pressed", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnListColor:
                Intent intentListView = new Intent(this,List_View_Color.class);
                startActivity(intentListView);
                Toast.makeText(getBaseContext(),"ListView pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnSensorList:
                Intent intentSensor_List = new Intent(this,Sensor_List_ListView.class);
                startActivity(intentSensor_List);
                Toast.makeText(getBaseContext(),"sensor ListView pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnMusic:
                Intent intentMusic = new Intent("android.intent.action.MUSIC_PLAYER");
                startActivity(intentMusic);
                Toast.makeText(getBaseContext(),"Music is pressed",Toast.LENGTH_LONG).show();
                Log.d("music","music open");
                break;
        }
    }
}
