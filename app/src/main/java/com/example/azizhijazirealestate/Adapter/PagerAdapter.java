package com.example.azizhijazirealestate.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.azizhijazirealestate.Fragment.FinancialCategoriesFragment;
import com.example.azizhijazirealestate.Fragment.FinancialMovementsFragment;

public class PagerAdapter extends FragmentStateAdapter {


    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new FinancialCategoriesFragment();
            default:
                return new FinancialMovementsFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
