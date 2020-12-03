package com.example.nestegggg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class splash extends AppCompatActivity {

    private static int splashTimeout=3000;//duration of the splashscreen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(splash.this, "Welcome", Toast.LENGTH_SHORT).show();
                Intent intent = new  Intent(splash.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        }, splashTimeout);
    }
}