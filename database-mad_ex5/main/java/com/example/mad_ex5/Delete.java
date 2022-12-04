package com.example.mad_ex5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Delete extends AppCompatActivity {
    Button deleteOk;
    EditText deleteName;
    String name;
    DBHandler dbHandler;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);

        deleteOk = (Button)findViewById(R.id.deleteButton);
        deleteName = (EditText) findViewById(R.id.deleteName);

        dbHandler = new DBHandler(Delete.this);

        deleteOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = deleteName.getText().toString();
                dbHandler.deleteEntry(name);
                Toast.makeText(Delete.this, "Entry Deleted", Toast.LENGTH_SHORT).show();

                deleteName.setText("");
            }
        });
    }
}
