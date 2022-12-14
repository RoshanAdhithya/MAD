package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int flag=0;
    //int mode=0;
    int gcnt=0;
    int arr[] = new int[]{0,0,0,0,0,0,0,0,0};
    public boolean chkWinner(int ind,int val){
        int r=(ind/3)*3;
        int c=ind%3;
        int cnt=0;
        for(int i=r;i<r+3;i++){
            if(arr[i]==val)cnt++;
        }
        if(cnt==3)return true;
        cnt=0;
        for(int i=c;i<9;i=i+3){
            if(arr[i]==val)cnt++;
        }
        if(cnt==3)return true;
        if(arr[0]==arr[4]&&arr[4]==arr[8]&&arr[4]==val)return true;
        if(arr[2]==arr[4]&&arr[4]==arr[6]&&arr[4]==val)return true;
        return false;
    }
    public void func(Button b0,TextView res,int ind){
        if(flag==0)
        {
            b0.setText("X");
            arr[ind]=1;
            gcnt++;
            if(chkWinner(ind,arr[ind])){
                res.setText("You Won");
            }
            if(gcnt==9)res.setText("Tied");
        }
        else{
            b0.setText("O");
            arr[ind]=2;
            gcnt++;
            if(chkWinner(ind,arr[ind])){
                res.setText("Computer Won");
            }
            if(gcnt==9)res.setText("Tied");
        }
        flag=1-flag;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView res = findViewById(R.id.res);
        Button b0 = findViewById(R.id.btn0);
        Button b1 = findViewById(R.id.btn1);
        Button b2 = findViewById(R.id.btn2);
        Button b3 = findViewById(R.id.btn3);
        Button b4 = findViewById(R.id.btn4);
        Button b5 = findViewById(R.id.btn5);
        Button b6 = findViewById(R.id.btn6);
        Button b7 = findViewById(R.id.btn7);
        Button b8 = findViewById(R.id.btn8);
        Button mode = findViewById(R.id.mode);

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
                Intent in = new Intent(getApplication(),MainActivity2.class);
                startActivity(in);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr[0]==0){
                    func(b0,res,0);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr[1]==0){
                    func(b1,res,1);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr[2]==0){
                    func(b2,res,2);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr[3]==0){
                    func(b3,res,3);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr[4]==0){
                    func(b4,res,4);
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr[5]==0){
                    func(b5,res,5);
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr[6]==0){
                    func(b6,res,6);
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr[7]==0){
                    func(b7,res,7);
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arr[8]==0){
                    func(b8,res,8);
                }
            }
        });



    }
}