package com.example.azizhijazirealestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.azizhijazirealestate.Api.controllers.AuthApiController;
import com.example.azizhijazirealestate.databinding.ActivityChangePasswordBinding;
import com.example.azizhijazirealestate.interfaces.ProcessCallback;

public class ChangePassword extends AppCompatActivity implements View.OnClickListener {

    ActivityChangePasswordBinding binding;

    AuthApiController authApiController = new AuthApiController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeView();
    }
    private void initializeView() {
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        binding.saveChangePassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.saveChangePassword) {
            performReset();
        } else {
            onBackPressed();
        }
    }

    private void performReset() {
        if (checkData()) {
            changePassword();
        }
    }

    private boolean checkData() {
        if (!binding.oldPassword.getText().toString().isEmpty() &&
                !binding.newPassword.getText().toString().isEmpty() &&
                !binding.passwordConfirmation.getText().toString().isEmpty() ){
            return true;
        }
        return false;
    }


    private void changePassword() {
         String OldPassword = String.valueOf(binding.oldPassword.getText().toString().isEmpty());
         String NewPassword = String.valueOf(binding.newPassword.getText().toString().isEmpty());
         String PasswordConfirmation = String.valueOf(binding.passwordConfirmation.getText().toString().isEmpty());

         authApiController.changePassword(OldPassword, NewPassword, PasswordConfirmation, new ProcessCallback() {
             @Override
             public void onSuccess(String message) {

             }

             @Override
             public void onFailure(String message) {

             }
         });

    }



}