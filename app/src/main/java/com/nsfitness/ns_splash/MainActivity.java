package com.nsfitness.ns_splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT=3000;
    SharedPreferences sharedPreferences;
    String RegistrationStat, permissionStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE);
        RegistrationStat = sharedPreferences.getString("Registered", ("No"));
        RegistrationStat = (RegistrationStat);

        if (RegistrationStat.equals("Yes")) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    /* Create an Intent that will start the Menu-Activity. */
                    Intent mainIntent = new Intent(MainActivity.this, NS_Home.class);
                    startActivity(mainIntent);
                    finish();
                }
            }, SPLASH_SCREEN_TIME_OUT);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    /* Create an Intent that will start the Menu-Activity. */
                    Intent mainIntent = new Intent(MainActivity.this, NS_Login.class);
                    startActivity(mainIntent);
                    finish();
                }
            }, SPLASH_SCREEN_TIME_OUT);
        }


    }
}