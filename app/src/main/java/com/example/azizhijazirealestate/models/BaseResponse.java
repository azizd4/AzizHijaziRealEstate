
package com.example.azizhijazirealestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponse<T> {

    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("list")
    @Expose
    public List<T> list = null;
    @SerializedName("data")
    @Expose
    public T object;

}
