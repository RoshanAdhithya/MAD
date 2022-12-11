package com.example.staticwebpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page = (WebView) findViewById(R.id.page);

        WebSettings webSettings = page.getSettings();
        webSettings.setJavaScriptEnabled(true);
        page.loadUrl("file:///android_asset/sample.html");
    }
}