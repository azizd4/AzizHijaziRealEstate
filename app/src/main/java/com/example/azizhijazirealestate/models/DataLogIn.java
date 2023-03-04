
package com.example.azizhijazirealestate.models;

import android.util.Log;

import com.example.azizhijazirealestate.Api.controllers.ApiController;
import com.example.azizhijazirealestate.interfaces.ProcessCallback;
import com.example.azizhijazirealestate.prefs.AppSharedPreferences;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataLogIn {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("tower_name")
    @Expose
    public String towerName;
    @SerializedName("token")
    @Expose
    public String token;
    @SerializedName("token_type")
    @Expose
    public String tokenType;
    @SerializedName("refresh_token")
    @Expose
    public String refreshToken;

    public String password;

    public void login(ProcessCallback callback) {
        Call<BaseResponse<DataLogIn>> call = ApiController.getInstance().getRetrofitRequests().login(email, password);
        call.enqueue(new Callback<BaseResponse<DataLogIn>>() {
            @Override
            public void onResponse(Call<BaseResponse<DataLogIn>> call, Response<BaseResponse<DataLogIn>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    AppSharedPreferences.getInstance().save(response.body().object);
                    callback.onSuccess(response.body().message);
                } else {
                    try {
                        String error = new String(response.errorBody().bytes(), StandardCharsets.UTF_8);
                        JSONObject jsonObject = new JSONObject(error);
                        Log.e("Retrofit-API", "onResponse: " + error);
                        Log.e("Retrofit-API", "onResponse: " + jsonObject.getString("message"));
                        callback.onFailure(jsonObject.getString("message"));
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<DataLogIn>> call, Throwable t) {
                callback.onFailure("Something went wrong");
            }
        });
    }

}
