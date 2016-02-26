package org.code_freak.com.msg_read_reply_show_project;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Shared_Contacts extends AppCompatActivity {
    public static final String KEY_CONTACT1 = "Key_Contact1";
    public static final String KEY_CONTACT2 = "Key_Contact2";
    public static final String KEY_CONTACT3 = "Key_Contact3";
    public static final String KEY_CONTACT4 = "Key_Contact4";
    public static final String KEY_CONTACT5 = "Key_Contact5";
    EditText etContactNumber;
    ListView lvContact;
    ArrayAdapter<String> adapter;
   // ArrayAdapter<String> adapter1;
    SharedPreferences sharedPreferences;
    Button btnAddContact;

    public void Save(View view){

    switch (view.getId()){
        case R.id.btnSave1:
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String no1 = etContactNumber.getText().toString();
            editor.putString(KEY_CONTACT1, no1);
            editor.commit();
            adapter.add(no1);
            break;

        case R.id.btnSave2:
            SharedPreferences.Editor editor1 = sharedPreferences.edit();
            String no2 = etContactNumber.getText().toString();
            editor1.putString(KEY_CONTACT2, no2);
            editor1.commit();
            adapter.add(no2);
            break;

        case R.id.btnSave3:
        SharedPreferences.Editor editor3 = sharedPreferences.edit();
            String no3 = etContactNumber.getText().toString();
            editor3.putString(KEY_CONTACT3, no3);
            editor3.commit();
            adapter.add(no3);
            break;

        }
        Toast.makeText(getBaseContext(),"number added",Toast.LENGTH_LONG).show();
       /* String num = etContactNumber.getText().toString();
        adapter.add(num);
        adapter.notifyDataSetChanged();*/

        // SavePrefrences(KEY_CONTACT, num);
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared__contacts_layout);

        etContactNumber = (EditText)findViewById(R.id.etContactNumber);
        lvContact  = (ListView) findViewById(R.id.lvContacts);
        adapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1);
        lvContact.setAdapter(adapter);
        btnAddContact = (Button)findViewById(R.id.btnAddNum);
        sharedPreferences = getSharedPreferences(KEY_CONTACT1, MODE_PRIVATE);

        Toast.makeText(this, sharedPreferences.getString(KEY_CONTACT1, "No Numebrs saved yet"),Toast.LENGTH_LONG).show();

        // LoadPreferences();
    }

   /* public void SavePrefrences(String key,String value){
        SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = data.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public void LoadPreferences(){
        SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(this);
        String dataSet = data.getString(KEY_CONTACT,"Not Available");
        adapter.add(dataSet);
        adapter.notifyDataSetChanged();
    }*/

}
