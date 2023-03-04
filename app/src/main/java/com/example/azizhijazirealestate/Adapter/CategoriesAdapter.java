package com.example.azizhijazirealestate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.azizhijazirealestate.databinding.CustomCategoriesItamBinding;
import com.example.azizhijazirealestate.models.CategoriesData;

import java.util.ArrayList;
import java.util.List;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder> {
    List<CategoriesData> categoriesData = new ArrayList<>();

    public CategoriesAdapter(List<CategoriesData> categoriesData) {
        this.categoriesData = categoriesData;
    }

    @NonNull
    @Override
    public CategoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomCategoriesItamBinding binding = CustomCategoriesItamBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CategoriesHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesHolder holder, int position) {
        holder.setData(categoriesData.get(position));

    }

    @Override
    public int getItemCount() {
        return categoriesData.size();
    }

    class CategoriesHolder extends RecyclerView.ViewHolder {
        CustomCategoriesItamBinding binding;
        public CategoriesHolder(@NonNull View itemView) {
            super(itemView);
            binding = CustomCategoriesItamBinding.bind(itemView);
        }
        public void setData(CategoriesData categoriesData){
            binding.id.setText(String.valueOf(categoriesData.id));
            binding.name.setText(categoriesData.name);
            binding.actionsCount.setText(categoriesData.actionsCount);
            binding.total.setText(String.valueOf(categoriesData.total));
        }
    }

}

