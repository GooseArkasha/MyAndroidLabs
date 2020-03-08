package com.GooseArkasha.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SplashScreen extends AppCompatActivity {

    private final static String TAG = "SplashScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void onResume(){
        super.onResume();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(TAG, "SLEEEEEEEEP");
                    Thread.sleep(60000);
                } catch (Exception e) {
                    Log.d(TAG, "Sleep Eror");
                }

                finish();
            }
        });
        thread.start();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
