
package com.example.azizhijazirealestate.models;

import com.example.azizhijazirealestate.Api.controllers.ApiController;
import com.example.azizhijazirealestate.interfaces.ListCallback;
import com.example.azizhijazirealestate.interfaces.ProcessCallback;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinancialMovementsData {

    @SerializedName("category_id")
    @Expose
    public String categoryId;
    @SerializedName("amount")
    @Expose
    public String amount;
    @SerializedName("details")
    @Expose
    public String details;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("actor_id")
    @Expose
    public Integer actorId;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("category_name")
    @Expose
    public String categoryName;

    public String actorType;


    public static void getFinancialMovements(ListCallback<FinancialMovementsData> listCallback ) {
        Call<BaseResponse<FinancialMovementsData>> call = ApiController.getInstance().getRetrofitRequests().getFinancialMovements();
        call.enqueue(new Callback<BaseResponse<FinancialMovementsData>>() {
            @Override
            public void onResponse(Call<BaseResponse<FinancialMovementsData>> call, Response<BaseResponse<FinancialMovementsData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listCallback.onSuccess(response.body().list);
                } else {
                    listCallback.onFailure("");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<FinancialMovementsData>> call, Throwable t) {

            }
        });
    }


}
