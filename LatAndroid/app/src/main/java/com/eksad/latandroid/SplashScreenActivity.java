package com.eksad.latandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        // logic unt delay
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                pindahKeLoginScreen();// pindah ke activity login
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 3000);
    }
    // pindah ke login screen
    private void pindahKeLoginScreen(){
        Intent intend = new Intent(SplashScreenActivity.this,
                LoginActivity.class);
        startActivity(intend);

        finish();// agar tidak kembali ke splash screen
    }

}
