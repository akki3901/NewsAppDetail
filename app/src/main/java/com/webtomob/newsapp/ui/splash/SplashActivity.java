package com.webtomob.newsapp.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

import com.webtomob.newsapp.ui.MainActivity;
import com.webtomob.newsapp.R;


public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        creatingSplashScreen();

    }

    /********* Creating Splash Screen ***********/

    private void creatingSplashScreen() {

        new CountDownTimer(2500, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
                finish();
            }
        }.start();
    }

    @Override
    public void onBackPressed() {

    }
}

