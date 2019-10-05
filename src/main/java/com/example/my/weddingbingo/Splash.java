package com.example.my.weddingbingo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {

            public void run() {

                Intent iHomeScreen = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(iHomeScreen);


                finish();
            }

        }, SPLASH_SCREEN_TIME);
    }
}
