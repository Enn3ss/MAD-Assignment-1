package com.example.mad_assignment_1.food_fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.food.Food;

public class FoodViewHolder extends RecyclerView.ViewHolder {
    ImageView foodIcon;
    TextView foodName;
    TextView foodPrice;

    public FoodViewHolder(@NonNull View view) {
        super(view);
        foodIcon = (ImageView) view.findViewById(R.id.foodIcon);
        foodName = (TextView) view.findViewById(R.id.foodName);
        foodPrice = (TextView) view.findViewById(R.id.foodPrice);
    }

    public void bind(Food food) {
        foodIcon.setImageResource(food.getImage());
        foodName.setText(food.getName());
        foodPrice.setText("$" + Double.toString(food.getPrice()));
    }
}
