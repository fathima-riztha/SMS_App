package com.example.smssendingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextMobileNo;
    EditText edittextMessage;
    String mobileno;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMobileNo=findViewById(R.id.num);
        edittextMessage=findViewById(R.id.msg);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},
                PackageManager.PERMISSION_GRANTED);
    }
    public void sendSMS(View view){

        mobileno=editTextMobileNo.getText().toString();
        message=edittextMessage.getText().toString();

        try{
            if(!mobileno.equals("") && !message.equals("")){
                SmsManager smgr=SmsManager.getDefault();
                smgr.sendTextMessage(mobileno,null,message,null, null );
                Toast.makeText(getApplicationContext(),"SMS Send to" +mobileno,Toast.LENGTH_LONG).show();
            }
        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "SMS sending failed", Toast.LENGTH_SHORT).show();
        }
    }



}