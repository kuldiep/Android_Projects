package org.code_freak.com.email_validation;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;



public class Email_Validation extends Activity {

    private final String TAG = "registration";
    TextView tvResult;
    EditText etResult;
    int day,month,year;
    String string = "Registration successfull";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email__validation_layout);


    }

    public void registeruserID(View view) {

        //Log.i(TAG, "inside method");

       /* etResult = (EditText) findViewById(R.id.etName);
        if(!(etResult.toString().matches("[a-zA-Z]]"))) {
            etResult.setError("Only Characters Are Allowed");
            if((etResult.getText().toString().isEmpty()))
                etResult.setError("Name Should not be Blank");
        }*/

        EditText etResult1 = (EditText) findViewById(R.id.etEmail);
        if (etResult1.getText().toString().isEmpty())
            etResult1.setError("You cannot leave this empty");


        String EMAIL_REGEX = "^[\\w -_\\.+]*[\\w -_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        if (!etResult1.getText().toString().matches(EMAIL_REGEX))
            etResult1.setError("Enter a valid Email-ID");


        EditText etPass = (EditText) findViewById(R.id.etPassword5121);
        if (etPass.getText().toString().isEmpty())
            etPass.setError("You cannot leave this empty");

        EditText etRepass = (EditText) findViewById(R.id.etRepeatPassword);
        if (etRepass.getText().toString().isEmpty())
            etRepass.setError("You cannot leave this empty");


        if (!etRepass.getText().toString().equals(etPass.getText().toString()))
            // Toast.makeText(getApplicationContext(), "These Password does not match!! Try Again??", Toast.LENGTH_LONG).show();
            etRepass.setError("These Password does not match!! Try Again??");

        RadioGroup gender = (RadioGroup) findViewById(R.id.rbRadioGroup);
        if (gender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();

        }

        EditText etDob = (EditText) findViewById(R.id.etDate);
        String dob = etDob.getText().toString();
        if((dob.length() < 8)||(dob.length() > 10)){  // accepted date format  "DD-MM-YYYY"
            etDob.setError("invalid Date of birth");
            return;
        }

        for(int i=0; i<dob.length(); i++){
            if((i==2)||(i==5)) {
                if (dob.charAt(i) != '-') {
                    etDob.setError("enter Date of birth in correct format");
                    return;
                }
            } else{
                if((dob.charAt(i) < '0') || (dob.charAt(i) > '9')){
                    etDob.setError("invalid Date of birth ");
                    return;
                }
            }
        }

        int day = Integer.parseInt(dob.charAt(0) +""+ dob.charAt(1));
        int month = Integer.parseInt(dob.charAt(3)+""+dob.charAt(4));
        int year = Integer.parseInt(dob.charAt(6)+""+dob.charAt(7)+""+dob.charAt(8)+""+dob.charAt(9));

        if((day < 0) || (day > 31)){
            etDob.setError("invalid day");
            return;
        }
        if((month < 0) || (month > 12)){
            etDob.setError("invalid month");
            return;
        }
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if((year > currentYear ) || (year < currentYear-100)){
            etDob.setError("Age Must not be greater Than 100");
            return;
        }
        if((currentYear - year) < 13){
            etDob.setError("only age above 13 years can register");
            return;
        }

        String email = etResult1.getText().toString();


        /*Intent intent=new Intent(this,SucessFull_Registration.class);
        startActivity(intent);*/

        SendMail sm = new SendMail(this,email,"","successful register");
        sm.execute();



    }

   /* private int getAge(int year, int month, int day){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = new Integer(age);
        return ageInt;
    }*/

}
