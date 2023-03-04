package com.example.azizhijazirealestate.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.azizhijazirealestate.AppController;
import com.example.azizhijazirealestate.models.DataLogIn;


enum PrefKeys {
    id, loggedIn, fullName, email, token
}

public class AppSharedPreferences {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private AppSharedPreferences() {
        sharedPreferences = AppController.getInstance().getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
    }

    private static AppSharedPreferences instance;

    public static AppSharedPreferences getInstance() {
        if (instance == null) {
            instance = new AppSharedPreferences();
        }

        return instance;
    }

    public void save(DataLogIn dataLogIn) {
        editor = sharedPreferences.edit();
        editor.putBoolean(PrefKeys.loggedIn.name(), true);
        editor.putInt(PrefKeys.id.name(), dataLogIn.id);
        editor.putString(PrefKeys.email.name(), dataLogIn.email);
        editor.putString(PrefKeys.email.name(), dataLogIn.password);
        editor.putString(PrefKeys.token.name(), "Bearer " + dataLogIn.token);
        editor.apply();
    }

    public String getToken() {
        return sharedPreferences.getString(PrefKeys.token.name(), "");
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(PrefKeys.loggedIn.name(), false);
    }

    public void clear() {
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
