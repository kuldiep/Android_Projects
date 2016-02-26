package org.code_freak.com.msg_read_reply_show_project;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Kuldiep on 2/18/2016.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Switch;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class SmsBroadcastReceiver extends BroadcastReceiver {
    Geocoder gc;
    String address;
    String phno = "9426967049";
    public static final String SMS_BUNDLE = "pdus";

    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();
        if (intentExtras != null) {
            Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
            String smsMessageStr = "";
            for (int i = 0; i < sms.length; ++i) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                String smsBody = smsMessage.getMessageBody().toString();
                address = smsMessage.getOriginatingAddress();
                Log.d("Kuldeep","phone num is :"+address);
                smsMessageStr += "SMS From: " + address + "\n";
                smsMessageStr += smsBody + "\n";
            }
            Toast.makeText(context, smsMessageStr, Toast.LENGTH_SHORT).show();

            //this will update the UI with message
 //           SmsActivity inst = SmsActivity.instance();
   //         inst.updateList(smsMessageStr);
            LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

          /*  if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }*/

            Location lastlocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            String ll = "location:"+
                    "\nlatitude = " +lastlocation.getLatitude() +
                    "\nlongitude = " +lastlocation.getLongitude();
            gc = new Geocoder(context, Locale.getDefault());
            String addinfo =null;
            gc = new Geocoder(context, Locale.getDefault());
            //String addinfo =null;
            //SmsManager smsManager = SmsManager.getDefault();
            try{
                List<Address>
                        addressList = gc.getFromLocation(lastlocation.getLatitude(),lastlocation.getLongitude(),1);
                if (addressList != null && addressList.size() > 0) {
                    Address address = addressList.get(0);
                    StringBuilder sb = new StringBuilder();
                    for (int i=0;i<address.getMaxAddressLineIndex();i++){
                        sb.append(address.getAddressLine(i)).append("\n");
                    }
                    sb.append(address.getLatitude()).append("\n");
                    sb.append(address.getLongitude()).append("\n");
                    addinfo = sb.toString();
                    Log.d("Kuldeep",""+addinfo);
                }
            } catch (IOException e) {
                Log.e("Kuldeep", "Unable to connect to Geocoder");
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("PhoneNumber", Context.MODE_PRIVATE);

            SmsManager smsManager = SmsManager.getDefault();
            if (address.equals(sharedPreferences.getString("abc" + 1, "")))
            smsManager.sendTextMessage(sharedPreferences.getString("abc"+1, ""), null, ll + addinfo, null, null);
             else if (address.equals(sharedPreferences.getString("abc"+2,"")))
            smsManager.sendTextMessage(sharedPreferences.getString("abc"+2, ""), null, ll + addinfo, null, null);
          else
            smsManager.sendTextMessage(sharedPreferences.getString("abc"+3, ""), null, ll + addinfo, null, null);
        }
    }
}
