package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Thread t1, t2;
    ImageView space;
    Button b1;
    int a, b, counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        space = (ImageView) findViewById(R.id.space);
        b1 = (Button) findViewById(R.id.bstart);

        Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        space.setBackgroundDrawable(new BitmapDrawable(bg));

        Canvas canvas = new Canvas(bg);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawRect(50, 300, 150, 500, paint);

        a = 0;
        b = 0;
        final int[] flag = {0};

        t1 = new Thread() {
            public void run() {
                while(true) {
                    while(flag[0] == 0) {
                        try {
                            Thread.sleep(10);
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    while(flag[0] == 1) {
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(a == 0) {
                                        space.setPivotX(0.0f);
                                        space.setPivotY(0.0f);
                                        space.animate().scaleX(2.0f).setDuration(100);
                                    }
                                    else if(a == 1) {
                                        space.setPivotX(0.0f);
                                        space.setPivotY(0.0f);
                                        space.animate().scaleX(3.0f).setDuration(100);
                                    }
                                    else if(a == 2) {
                                        space.setPivotX(0.0f);
                                        space.setPivotY(0.0f);
                                        space.animate().scaleX(4.0f).setDuration(100);
                                    }
                                    else if(a == 3) {
                                        space.setPivotX(0.0f);
                                        space.setPivotY(0.0f);
                                        space.animate().scaleX(5.0f).setDuration(100);
                                    }
                                    a++;
                                    a %= 4;
                                }
                            });
                            Thread.sleep(1000);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        t2 = new Thread() {
            public void run() {
                while(true) {
                    while(flag[0] == 0) {
                        try {
                            Thread.sleep(10);
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    while(flag[0] == 1) {
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(b == 0) {
                                        space.setBackgroundDrawable(new BitmapDrawable(bg));
                                        Canvas canvas = new Canvas(bg);
                                        Paint paint = new Paint();
                                        paint.setColor(Color.RED);
                                        canvas.drawRect(50, 300, 150, 500, paint);
                                    }
                                    else if(b == 1) {
                                        space.setBackgroundDrawable(new BitmapDrawable(bg));
                                        Canvas canvas = new Canvas(bg);
                                        Paint paint = new Paint();
                                        paint.setColor(Color.YELLOW);
                                        canvas.drawRect(50, 300, 150, 500, paint);
                                    }
                                    else if(b == 2) {
                                        space.setBackgroundDrawable(new BitmapDrawable(bg));
                                        Canvas canvas = new Canvas(bg);
                                        Paint paint = new Paint();
                                        paint.setColor(Color.GREEN);
                                        canvas.drawRect(50, 300, 150, 500, paint);
                                    }
                                    else if(b == 3) {
                                        space.setBackgroundDrawable(new BitmapDrawable(bg));
                                        Canvas canvas = new Canvas(bg);
                                        Paint paint = new Paint();
                                        paint.setColor(Color.BLUE);
                                        canvas.drawRect(50, 300, 150, 500, paint);
                                    }
                                    b++;
                                    b %= 4;
                                }
                            });
                            Thread.sleep(1000);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag[0] == 0) {
                    flag[0] = 1;
                    b1.setText("Stop");
                    if(counter == 0) {
                        t1.start();
                        t2.start();
                        counter++;
                    }
                }
                else {
                    flag[0] = 0;
                    b1.setText("Start");
                }
            }
        });
    }
}