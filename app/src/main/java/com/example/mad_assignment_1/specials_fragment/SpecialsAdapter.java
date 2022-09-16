package com.example.mad_assignment_1.specials_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.mad_assignment_1.CommonData;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.food.Food;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

import java.util.ArrayList;

public class SpecialsAdapter extends Adapter<SpecialsViewHolder> {
    FoodDBModel foodDBModel;
    ArrayList<Food> foods;

    public SpecialsAdapter(FoodDBModel foodDBModel) {
        this.foodDBModel = foodDBModel;
        this.foods = foodDBModel.getSpecials();
    }

    @NonNull
    @Override
    public SpecialsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.specials_view_holder, parent, false);
        return new SpecialsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialsViewHolder holder, int position) {
        holder.bind(foods.get(position));

        holder.specialIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.specialName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
