package com.example.azizhijazirealestate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.azizhijazirealestate.Api.controllers.AuthApiController;
import com.example.azizhijazirealestate.databinding.ActivityLogInBinding;
import com.example.azizhijazirealestate.interfaces.ProcessCallback;
import com.example.azizhijazirealestate.models.DataLogIn;
import com.google.android.material.snackbar.Snackbar;

public class LogIn extends AppCompatActivity implements View.OnClickListener {

    ActivityLogInBinding binding;
    AuthApiController authApiController = new AuthApiController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        initializeView();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    private void initializeView() {
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        binding.logIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.logIn) {
            performLogin();
        }
    }

    private void performLogin() {
        login();
    }

    private void login() {
        authApiController.login(getDataLogIn(), new ProcessCallback() {
            @Override
            public void onSuccess(String message) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(String message) {
                //TODO: must show error message
                Log.d("Retrofit", "onFailure: ");
                Snackbar.make(binding.getRoot(), message, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private DataLogIn getDataLogIn() {
        DataLogIn dataLogIn = new DataLogIn();
        dataLogIn.email = binding.email.getText().toString().trim();
        dataLogIn.password = binding.password.getText().toString().trim();
        return dataLogIn;
    }

}