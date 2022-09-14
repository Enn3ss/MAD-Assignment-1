package com.example.mad_assignment_1.data;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.restaurants.Restaurant;

import java.util.Arrays;
import java.util.List;

public class RestaurantData {
    private List<Restaurant> restaurantList = Arrays.asList(
            new Restaurant("1", "Chicken Treat", R.drawable.chicken_treat_icon),
            new Restaurant("2", "Dominos", R.drawable.dominos_logo),
            new Restaurant("3", "Forklore", R.drawable.forklore_logo),
            new Restaurant("4", "Grill'd", R.drawable.grilld_logo),
            new Restaurant("5", "KFC", R.drawable.kfc_logo),
            new Restaurant("6", "McDonalds", R.drawable.mcdonalds_logo),
            new Restaurant("7", "Nandos", R.drawable.nandos_logo),
            new Restaurant("8", "Red Rooster", R.drawable.red_rooster_logo),
            new Restaurant("9", "Subway", R.drawable.subway_logo),
            new Restaurant("10", "Zambrero", R.drawable.zambrero_logo)
    );

    private static RestaurantData instance = null;

    public static RestaurantData getInstance() {
        if (instance == null) {
            instance = new RestaurantData();
        }
        return instance;
    }

    protected RestaurantData() {}

    public Restaurant getAtIndex(int index) {
        return restaurantList.get(index);
    }

    public int size() {
        return restaurantList.size();
    }
}
