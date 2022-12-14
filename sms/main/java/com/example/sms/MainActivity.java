package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.view.View;
import android.telephony.SmsManager;
import android.widget.*;
import static android.Manifest.permission.RECEIVE_SMS;
import static android.Manifest.permission.SEND_SMS;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText number, msg;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,new String[]{READ_SMS, RECEIVE_SMS, READ_PHONE_STATE, SEND_SMS },1);
        number = findViewById(R.id.number);
        msg = findViewById(R.id.msg);

        send = findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phno = number.getText().toString();
                String message = msg.getText().toString();
                sendMsg(phno,message);
            }
        });
    }
    protected void sendMsg(String number, String message ){
        SmsManager smsMng = SmsManager.getDefault();
        smsMng.sendTextMessage(number,null,message,null,null);
    }
}