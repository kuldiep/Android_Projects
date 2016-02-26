package org.code_freak.com.msg_read_reply_show_project;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhoneNumber extends AppCompatActivity {
    private EditText etPhoneNumber;
    private Button btnSave1;
    int count=0;
    private ListView lvPhNum;
    private ArrayList<String> phonenum;
    private ArrayList<String> abc;


    public void SavePhone(View view){

        int a= ++count;
        SharedPreferences sharedPreferences = getSharedPreferences("PhoneNumber",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("abc" + a, etPhoneNumber.getText().toString());
        editor.apply();
        abc.add(etPhoneNumber.getText().toString());

        Toast.makeText(this,"Number Added",Toast.LENGTH_LONG).show();
        etPhoneNumber.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);
        etPhoneNumber = (EditText)findViewById(R.id.etPhoneNumber);
        btnSave1 = (Button) findViewById(R.id.btnSave1);
        lvPhNum = (ListView) findViewById(R.id.lvPhNum);
        abc=new ArrayList<String>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,abc);
        lvPhNum.setAdapter(arrayAdapter);








        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(
                        lvPhNum,
                        new SwipeDismissListViewTouchListener.DismissCallbacks() {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
//                                    mAdapter.remove(mAdapter.getItem(position));
                                    arrayAdapter.remove(arrayAdapter.getItem(position));

                                }
                                arrayAdapter.notifyDataSetChanged();
                            }
                        });
        lvPhNum.setOnTouchListener(touchListener);


    }



}
