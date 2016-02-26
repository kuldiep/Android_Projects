package org.code_freak.com.mybluetooth;

import android.app.Notification;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.List;

public class Bluetooth_Activity extends AppCompatActivity {
   private EditText etMsg;
    private static final Integer REQUEST_ENABLE_BT =1;
    private static final Integer DISCOVER_DURATION=300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_layout);
        etMsg = (EditText) findViewById(R.id.etMsg);
    }
    public void SendViaBluetooth(View view){
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if(btAdapter==null){
            Toast.makeText(getBaseContext(),"not available",Toast.LENGTH_LONG).show();

        }
        else
        {
            enableBluetooth();
        }

    }
    public void enableBluetooth(){
        Intent discoverIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,DISCOVER_DURATION);
        startActivityForResult(discoverIntent,REQUEST_ENABLE_BT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == DISCOVER_DURATION&&requestCode==REQUEST_ENABLE_BT){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            File f = new File(Environment.getExternalStorageDirectory(),"flag.txt");
            intent.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(f));
            PackageManager pm = getPackageManager();
            List<ResolveInfo> appList = pm.queryIntentActivities(intent,0);

            if(appList.size()>0){
                String packageName = null;
                String className = null;
                boolean found = false;
                for (ResolveInfo info : appList){
                    packageName = info.activityInfo.packageName;
                    if(packageName.equals("com.android.bluetooth")){
                        className = info.activityInfo.name;
                        found = true;
                        break;
                    }
                }
                if(!found){
                    Toast.makeText(getBaseContext(),"not found",Toast.LENGTH_LONG).show();
                }else{
                    intent.setClassName(packageName,className);
                    startActivity(intent);
                }
            }
        }else{
            Toast.makeText(getBaseContext(),"cancelled",Toast.LENGTH_LONG).show();
        }
    }
}
