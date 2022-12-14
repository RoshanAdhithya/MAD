package com.example.locprac;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;
import static android.Manifest.permission.RECEIVE_SMS;
import static android.Manifest.permission.SEND_SMS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.location.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView lat, lng;
    LocationManager lmg;
    LocationListener lis;
    Button btn, smsbtn;
    SmsManager sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lat = (TextView) (findViewById(R.id.lat));
        lng = (TextView) (findViewById(R.id.lng));
        btn = (Button) (findViewById(R.id.button));
        smsbtn = (Button) (findViewById(R.id.smsbtn));
        lmg = (LocationManager) (getSystemService(LOCATION_SERVICE));

        lis = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                lat.setText(Double.toString(location.getLatitude()));
                lng.setText(Double.toString(location.getLongitude()));
                sms = SmsManager.getDefault();
            }
        };

        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION, READ_SMS, SEND_SMS, READ_PHONE_STATE, RECEIVE_SMS}, 1);


        smsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sms = SmsManager.getDefault();
                sms.sendTextMessage("9999999999", null, "Latitude : " + lat.getText().toString() + "\nLongitude : " + lng.getText().toString(), null, null);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                lmg.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 10, lis);
            }
        });

    }
}