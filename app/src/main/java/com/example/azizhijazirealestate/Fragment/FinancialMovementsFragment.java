package com.example.azizhijazirealestate.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.azizhijazirealestate.Adapter.FinancialMovementsAdapter;
import com.example.azizhijazirealestate.Api.controllers.FinancialMovementsApiController;
import com.example.azizhijazirealestate.R;
import com.example.azizhijazirealestate.databinding.FragmentFinancialMovementsBinding;
import com.example.azizhijazirealestate.interfaces.ListCallback;
import com.example.azizhijazirealestate.models.FinancialMovementsData;

import java.util.ArrayList;
import java.util.List;

public class FinancialMovementsFragment extends Fragment {

    FinancialMovementsApiController financialMovementsApiController = new FinancialMovementsApiController();
    private List<FinancialMovementsData> financialMovementsData = new ArrayList<>();
    FinancialMovementsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentFinancialMovementsBinding binding = FragmentFinancialMovementsBinding.inflate(inflater);

        adapter = new FinancialMovementsAdapter(financialMovementsData);
        binding.rv.setAdapter(adapter);

        financialMovementsApiController.getFinancialMovements(new ListCallback<FinancialMovementsData>() {
            @Override
            public void onSuccess(List<FinancialMovementsData> list) {
                financialMovementsData.addAll(list);
                adapter.notifyItemRangeInserted(0, list.size());
            }

            @Override
            public void onFailure(String message) {
            }
        });

        return binding.getRoot();
    }
}