
package com.example.azizhijazirealestate.models;

import com.example.azizhijazirealestate.Api.controllers.ApiController;
import com.example.azizhijazirealestate.interfaces.ListCallback;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesData {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("actions_count")
    @Expose
    public String actionsCount;
    @SerializedName("total")
    @Expose
    public Integer total;

    public static void getCategories(ListCallback<CategoriesData> listCallback ) {
        Call<BaseResponse<CategoriesData>> call = ApiController.getInstance().getRetrofitRequests().getCategories();
        call.enqueue(new Callback<BaseResponse<CategoriesData>>() {
            @Override
            public void onResponse(Call<BaseResponse<CategoriesData>> call, Response<BaseResponse<CategoriesData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listCallback.onSuccess(response.body().list);
                } else {
                    listCallback.onFailure("");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<CategoriesData>> call, Throwable t) {

            }
        });
    }
}
