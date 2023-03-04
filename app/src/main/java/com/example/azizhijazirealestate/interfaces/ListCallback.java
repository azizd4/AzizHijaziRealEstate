package com.example.azizhijazirealestate.interfaces;

import java.util.List;

public interface ListCallback<T> {

    void onSuccess(List<T> list);

    void onFailure(String message);
}
