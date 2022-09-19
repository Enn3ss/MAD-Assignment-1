package com.example.mad_assignment_1.specials_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.mad_assignment_1.FoodViewModel;
import com.example.mad_assignment_1.activities.HomePageActivity;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.food.Food;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

import java.util.ArrayList;

public class SpecialsAdapter extends Adapter<SpecialsViewHolder> {
    FoodViewModel foodViewModel;

    public SpecialsAdapter() {
        this.foodViewModel = new ViewModelProvider(HomePageActivity.getInstance()).get(FoodViewModel.class);
    }

    @NonNull
    @Override
    public SpecialsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.special_view_holder, parent, false);
        return new SpecialsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialsViewHolder holder, int position) {
        ArrayList<Food> items = FoodDBModel.getInstance().getSpecials();

        holder.bind(items.get(position));

        holder.specialIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodViewModel.setValue(items.get(holder.getBindingAdapterPosition()).getId());
            }
        });

        holder.specialName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodViewModel.setValue(items.get(holder.getBindingAdapterPosition()).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
