package com.example.mad_ex5;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button binsert,bdelete,bdisplay,bedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binsert=(Button)findViewById(R.id.insert);
        bdelete=(Button)findViewById(R.id.delete);
        bdisplay=(Button)findViewById(R.id.display);
        bedit=(Button)findViewById(R.id.edit);

        binsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInsertActivity();
            }
        });

        bdisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDisplayActivity();
            }
        });

        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeleteActivity();
            }
        });

        bedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditActivity();
            }
        });
    }

    public void openInsertActivity() {
        Intent intent = new Intent(this, Insert.class);
        startActivity(intent);
    }

    public void openDisplayActivity() {
        Intent intent = new Intent(this, Display.class);
        startActivity(intent);
    }

    public void openDeleteActivity() {
        Intent intent = new Intent(this, Delete.class);
        startActivity(intent);
    }

    public void openEditActivity() {
        Intent intent = new Intent(this, Update.class);
        startActivity(intent);
    }
}