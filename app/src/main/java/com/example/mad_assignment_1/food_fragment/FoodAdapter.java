package com.example.mad_assignment_1.food_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.mad_assignment_1.FoodViewModel;
import com.example.mad_assignment_1.HomePageActivity;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.food.Food;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

import java.util.ArrayList;

public class FoodAdapter extends Adapter<FoodViewHolder> {
    FoodDBModel foodDBModel;
    String currentRestaurant;
    FoodViewModel foodViewModel;

    public FoodAdapter(FoodDBModel foodDBModel, String currentRestaurant) {
        this.foodDBModel = foodDBModel;
        this.currentRestaurant = currentRestaurant;
        this.foodViewModel = new ViewModelProvider(HomePageActivity.getInstance()).get(FoodViewModel.class);
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
        int currPostion = position;
        ArrayList<Food> food = foodDBModel.getFoodFrom(currentRestaurant);
        holder.bind(food.get(position));

        holder.foodIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodViewModel.setValue(food.get(currPostion).getId());
            }
        });

        holder.foodName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodViewModel.setValue(food.get(currPostion).getId());
            }
        });

        holder.foodPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodViewModel.setValue(food.get(currPostion).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodDBModel.getSizeFrom(currentRestaurant);
    }
}
