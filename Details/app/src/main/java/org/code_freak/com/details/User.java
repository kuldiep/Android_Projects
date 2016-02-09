package org.code_freak.com.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class User extends AppCompatActivity {

       @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
            if (requestCode == 1 && resultCode == RESULT_OK) {
                String name = intent.getStringExtra("name");
                Toast.makeText(getBaseContext(), "Name : " + name, Toast.LENGTH_LONG).show();
            }

            Log.i("kuldeep", "on activity result executed");
           if (requestCode == 2 && resultCode == RESULT_OK) {
               String name = intent.getStringExtra("name");
               Toast.makeText(getBaseContext(), "Office Name : " + name, Toast.LENGTH_LONG).show();
           }

        }


        public void getUserDetials(View view) {
            switch (view.getId()) {
                case R.id.btnUserInfo:
                    Intent intentUserPersonalInfo = new Intent(getBaseContext(), User_Personal_Detail.class);
                    startActivityForResult(intentUserPersonalInfo, 1);
                    break;
                case R.id.btnUserOfficialInfo:
                    Intent btnUserOfficialInfo = new Intent(getBaseContext(), User_Office_Detail.class);
                    startActivityForResult(btnUserOfficialInfo, 2);
                    break;
            }
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user);

        }

}
