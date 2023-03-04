package com.example.azizhijazirealestate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.azizhijazirealestate.databinding.CustomFinancialMovementsItamBinding;
import com.example.azizhijazirealestate.models.FinancialMovementsData;


import java.util.ArrayList;
import java.util.List;


public class FinancialMovementsAdapter extends RecyclerView.Adapter<FinancialMovementsAdapter.FinancialMovementsHolder> {
    List<FinancialMovementsData> financialMovementsData = new ArrayList<>();

    public FinancialMovementsAdapter(List<FinancialMovementsData> financialMovementsData) {
        this.financialMovementsData = financialMovementsData;
    }

    @NonNull
    @Override
    public FinancialMovementsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomFinancialMovementsItamBinding binding = CustomFinancialMovementsItamBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new FinancialMovementsHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull FinancialMovementsHolder holder, int position) {
        holder.setData(financialMovementsData.get(position));

    }

    @Override
    public int getItemCount() {
        return financialMovementsData.size();
    }


    class FinancialMovementsHolder extends RecyclerView.ViewHolder {
        CustomFinancialMovementsItamBinding binding;
        public FinancialMovementsHolder(@NonNull View itemView) {
            super(itemView);
            binding = CustomFinancialMovementsItamBinding.bind(itemView);
        }
        public void setData(FinancialMovementsData financialMovementsData){
            binding.categoryId.setText(financialMovementsData.categoryId);
            binding.categoryName.setText(financialMovementsData.categoryName);
            binding.amount.setText(financialMovementsData.amount);
            binding.details.setText(financialMovementsData.details);
            binding.actorId.setText(String.valueOf(financialMovementsData.actorId));
            binding.date.setText(financialMovementsData.date);
        }
    }


}

