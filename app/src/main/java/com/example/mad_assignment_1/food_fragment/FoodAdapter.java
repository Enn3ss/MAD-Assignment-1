package com.example.mad_assignment_1.food_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.food.Food;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

import java.util.ArrayList;

public class FoodAdapter extends Adapter<FoodViewHolder> {
    FoodDBModel foodDBModel;
    String currentRestaurant;

    public FoodAdapter(FoodDBModel foodDBModel, String currentRestaurant) {
        this.foodDBModel = foodDBModel;
        this.currentRestaurant = currentRestaurant;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.food_view_holder, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        ArrayList<Food> food = foodDBModel.getFoodFrom(currentRestaurant);
        holder.bind(food.get(position));
    }

    @Override
    public int getItemCount() {
        return foodDBModel.getSizeFrom(currentRestaurant);
    }
}
