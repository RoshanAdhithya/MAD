package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    int ggcnt=0;
    int arr1[] = new int[]{0,0,0,0,0,0,0,0,0};

    public boolean chkWinner(int ind,int val){
        int r=(ind/3)*3;
        int c=ind%3;
        int cnt=0;
        for(int i=r;i<r+3;i++){
            if(arr1[i]==val)cnt++;
        }
        if(cnt==3)return true;
        cnt=0;
        for(int i=c;i<9;i=i+3){
            if(arr1[i]==val)cnt++;
        }
        if(cnt==3)return true;
        if(arr1[0]==arr1[4]&&arr1[4]==arr1[8]&&arr1[4]==val)return true;
        if(arr1[2]==arr1[4]&&arr1[4]==arr1[6]&&arr1[4]==val)return true;
        return false;
    }
    public void func(Button b,TextView res,int ind){
        Button b0 = findViewById(R.id.bbtn0);
        Button b1 = findViewById(R.id.bbtn1);
        Button b2 = findViewById(R.id.bbtn2);
        Button b3 = findViewById(R.id.bbtn3);
        Button b4 = findViewById(R.id.bbtn4);
        Button b5 = findViewById(R.id.bbtn5);
        Button b6 = findViewById(R.id.bbtn6);
        Button b7 = findViewById(R.id.bbtn7);
        Button b8 = findViewById(R.id.bbtn8);
        b.setText("X");
        arr1[ind]=1;
        ggcnt++;
        if(chkWinner(ind,arr1[ind])){
            res.setText("You Won");
        }
        if(ggcnt==9)res.setText("Tied");

        int cb = (int)(Math.random()*(8));
        while(arr1[cb]!=0){
            cb = (int)(Math.random()*(8));
        }
        switch(cb){
            case 0:b0.setText("O");break;
            case 1:b1.setText("O");break;
            case 2:b2.setText("O");break;
            case 3:b3.setText("O");break;
            case 4:b4.setText("O");break;
            case 5:b5.setText("O");break;
            case 6:b6.setText("O");break;
            case 7:b7.setText("O");break;
            case 8:b8.setText("O");break;
        }

        arr1[cb]=2;
        ggcnt++;
        if(chkWinner(cb,arr1[cb])){
            res.setText("Computer Won");
        }
        if(ggcnt==9)res.setText("Tied");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView res = findViewById(R.id.res1);
        Button b0 = findViewById(R.id.bbtn0);
        Button b1 = findViewById(R.id.bbtn1);
        Button b2 = findViewById(R.id.bbtn2);
        Button b3 = findViewById(R.id.bbtn3);
        Button b4 = findViewById(R.id.bbtn4);
        Button b5 = findViewById(R.id.bbtn5);
        Button b6 = findViewById(R.id.bbtn6);
        Button b7 = findViewById(R.id.bbtn7);
        Button b8 = findViewById(R.id.bbtn8);
        Button mode = findViewById(R.id.mode1);
        b0.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplication(),MainActivity.class);
                startActivity(in);
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr1[0]==0){
                    func(b0,res,0);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr1[1]==0){
                    func(b1,res,1);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr1[2]==0){
                    func(b2,res,2);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr1[3]==0){
                    func(b3,res,3);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr1[4]==0){
                    func(b4,res,4);
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr1[5]==0){
                    func(b5,res,5);
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr1[6]==0){
                    func(b6,res,6);
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr1[7]==0){
                    func(b7,res,7);
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr1[8]==0){
                    func(b8,res,8);
                }
            }
        });



    }
}