package com.example.mad_ex5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Display extends AppCompatActivity {

    private ArrayList<PersonalInfoModal> PersonalInfoList;
    private DBHandler dbHandler;
    private DisplayAdapter displayAdapter;
    private RecyclerView infoRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        PersonalInfoList = new ArrayList<>();
        dbHandler = new DBHandler(Display.this);

        PersonalInfoList = dbHandler.getInfo();

        displayAdapter = new DisplayAdapter(PersonalInfoList, Display.this);
        infoRV = findViewById(R.id.PersonalInfoRecords);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Display.this, RecyclerView.VERTICAL, false);
        infoRV.setLayoutManager(linearLayoutManager);

        infoRV.setAdapter(displayAdapter);
    }
}
