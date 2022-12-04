package com.example.mad_ex5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Edit extends AppCompatActivity {

    Button bback1,bsubmit1;
    EditText addr1,phone1,email1;
    TextView name1;
    private DBHandler dbHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        Intent intent = getIntent();

        String str = intent.getStringExtra("info");

        String []str1 = str.split(":");

        bback1=(Button)findViewById(R.id.editBack);
        bsubmit1=(Button)findViewById(R.id.editSubmit);

        name1=(TextView) findViewById(R.id.editName1);
        addr1=(EditText)findViewById(R.id.editAddress);
        phone1=(EditText)findViewById(R.id.editPhone);
        email1=(EditText)findViewById(R.id.editEmail);

        name1.setText(str1[0]);
        addr1.setText(str1[1]);
        phone1.setText(str1[2]);
        email1.setText(str1[3]);

        dbHandler = new DBHandler(Edit.this);

        bback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });

        bsubmit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addr2=addr1.getText().toString();
                String phone2=phone1.getText().toString();
                String email2=email1.getText().toString();

                if(addr2.isEmpty()) {
                    Toast.makeText(Edit.this, "Please enter the address", Toast.LENGTH_SHORT).show();
                    return;
                } else if(phone2.isEmpty()) {
                    Toast.makeText(Edit.this, "Please enter the phone no.", Toast.LENGTH_SHORT).show();
                    return;
                } else if(email2.isEmpty()) {
                    Toast.makeText(Edit.this, "Please enter the email", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.updateInfo(str1[0],addr2,phone2,email2);
                Toast.makeText(Edit.this, "Successfully Updated", Toast.LENGTH_SHORT).show();

                goBack();
            }
        });
    }

    public void goBack() {
        Intent intent = new Intent(this,Update.class);
        startActivity(intent);
    }
}
