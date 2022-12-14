package com.example.caranimation;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    int flag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setRotation(45);


        new Thread(() -> {
            int i = 1;
            int x = 1;
            int inc = 1;
            while (i++ != 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (flag == 0) --i;
                else {
                    int finalI = i;
                    int finalX = x;
                    runOnUiThread(() -> {
                        imageView.setTranslationX(finalI);
                        imageView.setTranslationY(finalX);
                    });
                    x += inc;
                    if(x == 100) {
                        inc = -1;
                        imageView.setRotation(-45);
                    }
                    if(x == 0) {
                        inc = 1;
                        imageView.setRotation(45);
                    }
                }
            }
        }).start();
    }
}
