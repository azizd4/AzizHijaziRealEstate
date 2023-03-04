package com.example.azizhijazirealestate.Api;



import com.example.azizhijazirealestate.models.BaseResponse;
import com.example.azizhijazirealestate.models.CategoriesData;
import com.example.azizhijazirealestate.models.DataLogIn;
import com.example.azizhijazirealestate.models.FinancialMovementsData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

//Service Interface - Retrofit - API EndPoints
public interface RetrofitRequests {

    //LogIn and Logout
    @FormUrlEncoded
    @POST("auth/login")
    Call<BaseResponse<DataLogIn>> login(@Field("email") String email, @Field("password") String password);

    @GET("auth/logout")
    Call<BaseResponse> logout();

    @FormUrlEncoded
    @POST("auth/change-password")
    Call<BaseResponse> changePassword (@Field("current_password") String current_password,
                                       @Field("new_password") String new_password,
                                       @Field("new_password_confirmation") String new_password_confirmation);


    //CategoriesData
    @GET("categories")
    Call<BaseResponse<CategoriesData>> getCategories();

    //FinancialMovements
    @GET("operations")
    Call<BaseResponse<FinancialMovementsData>> getFinancialMovements();
}
