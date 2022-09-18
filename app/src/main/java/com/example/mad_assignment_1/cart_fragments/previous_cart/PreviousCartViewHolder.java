package com.example.mad_assignment_1.cart_fragments.previous_cart;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.food.Food;

public class PreviousCartViewHolder extends ViewHolder {
    ImageView previousCartItemIcon;
    TextView previousCartItemName;
    TextView previousCartItemPrice;

    public PreviousCartViewHolder(@NonNull View view) {
        super(view);

        previousCartItemIcon = (ImageView) view.findViewById(R.id.previousCartItemIcon);
        previousCartItemName = (TextView) view.findViewById(R.id.previousCartItemName);
        previousCartItemPrice = (TextView) view.findViewById(R.id.previousCartItemPrice);
    }

    public void bind(Food food) {
        previousCartItemIcon.setImageResource(food.getImage());
        previousCartItemName.setText(food.getName());
        previousCartItemPrice.setText(Double.toString(food.getPrice()));
    }
}
