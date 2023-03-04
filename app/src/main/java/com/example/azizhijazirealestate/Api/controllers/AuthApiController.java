package com.example.azizhijazirealestate.Api.controllers;


import android.util.Log;

import com.example.azizhijazirealestate.interfaces.ProcessCallback;
import com.example.azizhijazirealestate.models.BaseResponse;
import com.example.azizhijazirealestate.models.DataLogIn;
import com.example.azizhijazirealestate.prefs.AppSharedPreferences;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthApiController {

    public void login(DataLogIn dataLogIn, ProcessCallback callback) {
        if (!dataLogIn.email.isEmpty() && !dataLogIn.password.isEmpty()) {
            dataLogIn.login(callback);
        }else {
            callback.onFailure("Enter required data!");
        }
    }

    public void logout(ProcessCallback callback) {
        Call<BaseResponse> call = ApiController.getInstance().getRetrofitRequests().logout();
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.code() == 200 || response.code() == 401) {
                    AppSharedPreferences.getInstance().clear();
                    callback.onSuccess(response.code() == 200 ? response.body().message : "Logged out successfully");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                callback.onFailure("Something went wrong");
            }
        });
    }

    public void changePassword(String oldPassword, String newPassword, String confirmPassword, ProcessCallback callback) {
        Call<BaseResponse> call = ApiController.getInstance().getRetrofitRequests().changePassword(oldPassword, newPassword, confirmPassword);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().message);
                } else {
                    try {
                        String error = new String(response.errorBody().bytes(), StandardCharsets.UTF_8);
                        JSONObject jsonObject = new JSONObject(error);
                        Log.e("RETROFIT-API", "onResponse: " + error);
                        Log.e("RETROFIT-API", "onResponse: " + jsonObject.getString("message"));
                        callback.onFailure(jsonObject.getString("message"));
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                callback.onFailure("Something Went Wrong");
            }
        });
    }
}
