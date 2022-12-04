package com.example.mad_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button bup,bdown,bzoom,brotate,bback,bforward,bnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bup=(Button)findViewById(R.id.b_up);
        bdown=(Button)findViewById(R.id.b_down);
        bzoom=(Button)findViewById(R.id.b_zoom);
        brotate=(Button)findViewById(R.id.b_rotate);
        bforward=(Button)findViewById(R.id.b_forw);
        bback=(Button)findViewById(R.id.b_back);
        img=(ImageView)findViewById(R.id.img);

        bnext=(Button)findViewById(R.id.next);

        brotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_in));
            }
        });

        bzoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in));
            }
        });

        bup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.animate().translationYBy(-300).setDuration(600);
            }
        });

        bdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.animate().translationYBy(300).setDuration(600);
            }
        });

        bforward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.animate().translationXBy(300).setDuration(600);
            }
        });

        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.animate().translationXBy(-300).setDuration(600);
            }
        });

        bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoNext();
            }
        });
    }

    public void gotoNext() {
        Intent intent = new Intent(this,Graphics.class);
        startActivity(intent);
    }
}