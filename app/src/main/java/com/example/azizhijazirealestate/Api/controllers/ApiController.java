package com.example.azizhijazirealestate.Api.controllers;


import com.example.azizhijazirealestate.Api.RetrofitRequests;
import com.example.azizhijazirealestate.Api.RetrofitSettings;

public class ApiController {

    private RetrofitRequests retrofitRequests;
    private static ApiController instance;

    private ApiController() {
        retrofitRequests = RetrofitSettings.getInstance().create(RetrofitRequests.class);
    }

    public static synchronized ApiController getInstance() {
        if(instance == null) {
            instance = new ApiController();
        }
        return instance;
    }

    public RetrofitRequests getRetrofitRequests() {
        return retrofitRequests;
    }
}
