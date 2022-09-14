package com.example.mad_assignment_1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.mad_assignment_1.databases.food.FoodDBModel;
import com.example.mad_assignment_1.databases.restaurants.RestaurantDBModel;
import com.example.mad_assignment_1.restaurants_fragment.RestaurantFragment;
import com.example.mad_assignment_1.specials_fragment.SpecialsFragment;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        System.out.println("begin");

        RestaurantDBModel restaurantDBModel = new RestaurantDBModel();
        restaurantDBModel.load(getApplicationContext());

        FoodDBModel foodDBModel = new FoodDBModel();
        foodDBModel.load(getApplicationContext());

        FragmentManager fragmentManager = getSupportFragmentManager();
        RestaurantFragment restaurantFragment = (RestaurantFragment) fragmentManager.findFragmentById(R.id.restaurantFragmentContainer);
        SpecialsFragment specialsFragment = (SpecialsFragment) fragmentManager.findFragmentById(R.id.specialsFragmentContainer);

        if (restaurantFragment == null) {
            restaurantFragment = new RestaurantFragment(restaurantDBModel);
            fragmentManager.beginTransaction().add(R.id.restaurantFragmentContainer, restaurantFragment).commit();
        }

        if (specialsFragment == null) {
            specialsFragment = new SpecialsFragment(foodDBModel);
            fragmentManager.beginTransaction().add(R.id.specialsFragmentContainer, specialsFragment).commit();
        }
    }
}
