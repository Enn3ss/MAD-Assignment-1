package com.example.mad_assignment_1.checkout_recycler_view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.food.Food;

public class CheckoutViewHolder extends RecyclerView.ViewHolder
{
    public ImageView foodIconImage;
    public TextView foodNameTextBox;
    public TextView foodPriceTextBox;

    public CheckoutViewHolder(@NonNull View itemView)
    {
        super(itemView);

        foodIconImage = (ImageView) itemView.findViewById(R.id.icon);
        foodNameTextBox = (TextView) itemView.findViewById(R.id.name);
        foodPriceTextBox = (TextView) itemView.findViewById(R.id.price);
    }

    public void bind(Food food)
    {
        foodIconImage.setImageResource(food.getImage());
        foodNameTextBox.setText(food.getName());
        foodPriceTextBox.setText("$" + String.valueOf(food.getPrice()));
    }
}
