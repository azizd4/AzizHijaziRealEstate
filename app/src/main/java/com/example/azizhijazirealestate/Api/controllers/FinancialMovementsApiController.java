package com.example.azizhijazirealestate.Api.controllers;

import com.example.azizhijazirealestate.interfaces.ListCallback;
import com.example.azizhijazirealestate.interfaces.ProcessCallback;
import com.example.azizhijazirealestate.models.FinancialMovementsData;

public class FinancialMovementsApiController {

    public void getFinancialMovements(ListCallback<FinancialMovementsData> callback) {
        FinancialMovementsData.getFinancialMovements(callback);
    }

}
