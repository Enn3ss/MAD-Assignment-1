package com.example.mad_assignment_1.restaurants_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.mad_assignment_1.activities.HomePageActivity;
import com.example.mad_assignment_1.RestaurantViewModel;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.restaurants.Restaurant;
import com.example.mad_assignment_1.databases.restaurants.RestaurantDBModel;

import java.util.ArrayList;

public class RestaurantAdapter extends Adapter<RestaurantViewHolder> {
    RestaurantDBModel restaurantDBModel;
    RestaurantViewModel restaurantViewModel;

    public RestaurantAdapter(RestaurantDBModel restaurantDBModel) {
        this.restaurantDBModel = restaurantDBModel;
        this.restaurantViewModel = new ViewModelProvider(HomePageActivity.getInstance()).get(RestaurantViewModel.class);
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.restaurant_view_holder, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        int currPosition = position;
        ArrayList<Restaurant> restaurants = restaurantDBModel.getAllRestaurants();
        holder.bind(restaurants.get(position));

        holder.restaurantIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restaurantViewModel.setValue(restaurants.get(currPosition).getId());
            }
        });

        holder.restaurantName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restaurantViewModel.setValue(restaurants.get(currPosition).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantDBModel.getSize();
    }
}
