package com.example.mad_ex5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Update extends AppCompatActivity {
    Button updateOk;
    EditText updateName;
    String name;
    DBHandler dbHandler;
    PersonalInfoModal info;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        updateOk = (Button)findViewById(R.id.editButton);
        updateName = (EditText) findViewById(R.id.editName);

        dbHandler = new DBHandler(Update.this);

        updateOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = updateName.getText().toString();
                info = dbHandler.getIndividualInfo(name);
                if(info==null)
                    Toast.makeText(Update.this, "No such entry", Toast.LENGTH_SHORT).show();
                else {
                    openEditActivity(info);
                }
            }
        });
    }

    public void openEditActivity(PersonalInfoModal info) {
        System.out.println("Trying to open Edit Activity");
        Intent intent = new Intent(this, Edit.class);
        System.out.println(info.getName()+":"+info.getAddress()+":"+info.getPhone()+":"+info.getEmail());
        intent.putExtra("info",info.getName()+":"+info.getAddress()+":"+info.getPhone()+":"+info.getEmail());
        startActivity(intent);
    }
}
