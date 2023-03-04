package com.example.azizhijazirealestate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.azizhijazirealestate.databinding.ActivitySplashBinding;
import com.example.azizhijazirealestate.prefs.AppSharedPreferences;

public class Splash extends AppCompatActivity {

    ActivitySplashBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        controlSplashActivity();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    private void controlSplashActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isLoggedIn = AppSharedPreferences.getInstance().isLoggedIn();
                Intent intent = new Intent(getApplicationContext(), isLoggedIn ? MainActivity.class : LogIn.class);
                startActivity(intent);
            }
        }, 3000);
    }

}