package com.example.azizhijazirealestate.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.azizhijazirealestate.Adapter.CategoriesAdapter;
import com.example.azizhijazirealestate.Api.controllers.CategoriesApiController;
import com.example.azizhijazirealestate.R;
import com.example.azizhijazirealestate.databinding.FragmentFinancialCategoriesBinding;
import com.example.azizhijazirealestate.interfaces.ListCallback;
import com.example.azizhijazirealestate.models.CategoriesData;

import java.util.ArrayList;
import java.util.List;


public class FinancialCategoriesFragment extends Fragment {

    CategoriesApiController categoriesApiController = new CategoriesApiController();
    private List<CategoriesData> categoriesData = new ArrayList<>();
    CategoriesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFinancialCategoriesBinding binding = FragmentFinancialCategoriesBinding.inflate(inflater);

        adapter = new CategoriesAdapter(categoriesData);
        binding.rv.setAdapter(adapter);

        categoriesApiController.getCategories(new ListCallback<CategoriesData>() {
            @Override
            public void onSuccess(List<CategoriesData> list) {
                categoriesData.addAll(list);
                adapter.notifyItemRangeInserted(0, list.size());
            }

            @Override
            public void onFailure(String message) {
            }
        });

        return binding.getRoot();
    }
}