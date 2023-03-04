package com.example.azizhijazirealestate.Api.controllers;

import com.example.azizhijazirealestate.interfaces.ListCallback;
import com.example.azizhijazirealestate.models.CategoriesData;


public class CategoriesApiController {

    public void getCategories(ListCallback<CategoriesData> callback) {
        CategoriesData.getCategories(callback);
    }


}
