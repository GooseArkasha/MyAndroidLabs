package com.GooseArkasha.lab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SplashScreen extends AppCompatActivity {

    private final static String TAG = "SplashScreen";
    private boolean threadStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void onResume(){
        super.onResume();

        if(!threadStarted) {
            Thread thread = new Thread(new Runnable() { //Создаем новый поток
                @Override
                public void run() { //Переопределяем метод, который вызывается при запуске потока
                    try {
                        Log.d(TAG, "SLEEEEEEEEP");
                        Thread.sleep(2000); //Останавливаем работу потока на 2 с.
                    } catch (Exception e) {
                        Log.d(TAG, "Sleep Eror");
                    }

                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            thread.start();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("threadStarted", true);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        threadStarted = savedInstanceState.getBoolean("threadStarted");
    }
}
