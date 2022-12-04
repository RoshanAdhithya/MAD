package com.example.mad_ex5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {

    Button bback,bsubmit;
    EditText name,addr,phone,email;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);

        bback=(Button)findViewById(R.id.back);
        bsubmit=(Button)findViewById(R.id.submit);

        name=(EditText)findViewById(R.id.name1);
        addr=(EditText)findViewById(R.id.address);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);

        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });

        dbHandler = new DBHandler(Insert.this);

        bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=name.getText().toString();
                String addr1=addr.getText().toString();
                String phone1=phone.getText().toString();
                String email1=email.getText().toString();

                if(name1.isEmpty()) {
                    Toast.makeText(Insert.this, "Please enter the name", Toast.LENGTH_SHORT).show();
                    return;
                } else if(addr1.isEmpty()) {
                    Toast.makeText(Insert.this, "Please enter the address", Toast.LENGTH_SHORT).show();
                    return;
                } else if(phone1.isEmpty()) {
                    Toast.makeText(Insert.this, "Please enter the phone no.", Toast.LENGTH_SHORT).show();
                    return;
                } else if(email1.isEmpty()) {
                    Toast.makeText(Insert.this, "Please enter the email", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewEntry(name1,addr1,phone1,email1);
                Toast.makeText(Insert.this, "Successfully Inserted", Toast.LENGTH_SHORT).show();

                name.setText("");
                addr.setText("");
                phone.setText("");
                email.setText("");
            }
        });
    }
    public void goBack() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
