package org.code_freak.com.get_contact;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GetContact extends AppCompatActivity {
    EditText etContactNumber;
    EditText etContactName;
    Button btnContact;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Uri contactData = intent.getData();
            Cursor c = getContentResolver().query(contactData,null,null,null,null);
            if (c.moveToFirst()){
                String id = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));
                String hasPhone = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                if(hasPhone.equalsIgnoreCase("1")){
                    Cursor phone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null);
                    phone.moveToFirst();
                    String num = phone.getString((phone.getColumnIndex("data1")));
                    System.out.println("num is:" + num);
                    String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                   etContactName.setText(name);
                    etContactNumber.setText(num);
                }
                String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

            }

        }
    }
       // Log.i("kuldeep", "on activity result executed");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_contact_layout);
        btnContact = (Button)findViewById(R.id.btnContact);
        etContactNumber=(EditText) findViewById(R.id.etContactNumber);
        etContactName=(EditText) findViewById(R.id.etContactName);

    }

    public void Get_Contact(View view){

        Intent intentContact = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intentContact,1);

    }
}
