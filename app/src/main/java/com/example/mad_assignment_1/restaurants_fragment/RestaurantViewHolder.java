package com.example.mad_assignment_1.restaurants_fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.restaurants.Restaurant;

public class RestaurantViewHolder extends ViewHolder {
    ImageView restaurantIcon;
    TextView restaurantName;

    public RestaurantViewHolder(@NonNull View view) {
        super(view);
        restaurantIcon = (ImageView) view.findViewById(R.id.restaurantIcon);
        restaurantName = (TextView) view.findViewById(R.id.restaurantName);
    }

    public void bind(Restaurant restaurant) {
        restaurantIcon.setImageResource(restaurant.getImage());
        restaurantName.setText(restaurant.getName());
    }
}
