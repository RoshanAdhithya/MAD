package com.example.mad_ex9_sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumber, messageToSend;
    Button sendButton;
    String phoneNo = "null";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendButton = findViewById(R.id.sendButton);
        phoneNumber = findViewById(R.id.phoneNumber);
        messageToSend = findViewById(R.id.messageToSend);

        sendButton.setOnClickListener(view -> {
            String number = phoneNumber.getText().toString();
            String msg= messageToSend.getText().toString();
            try {
                if(phoneNo.equals(phoneNumber.getText().toString())){
                    Toast.makeText(getApplicationContext(),"You have already send a message to this number",
                            Toast.LENGTH_LONG).show();
                    phoneNumber.setText("");
                    messageToSend.setText("");
                    System.out.println(phoneNo);
                }
                else{
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(number,null,msg,null,null);
                    Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_LONG).show();
                    phoneNo = phoneNumber.getText().toString();
                    phoneNumber.setText("");
                    messageToSend.setText("");
                }
            }catch (SecurityException e) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.SEND_SMS}, 44);
                }
            } catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),"Please fill all fields!",Toast.LENGTH_LONG).show();
            }
        });

    }
}