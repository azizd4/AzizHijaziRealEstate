package com.example.azizhijazirealestate.models;

public class ApiResponse {

    final String message;
    final boolean success;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
