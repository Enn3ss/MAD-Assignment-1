package com.example.mad_assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.mad_assignment_1.databases.carts.CartDBModel;
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

        CartDBModel cartDBModel = new CartDBModel();
        cartDBModel.load(getApplicationContext());

        FragmentManager fragmentManager = getSupportFragmentManager();
        RestaurantFragment restaurantFragment = (RestaurantFragment) fragmentManager.findFragmentById(R.id.restaurantFragmentContainer);
        SpecialsFragment specialsFragment = (SpecialsFragment) fragmentManager.findFragmentById(R.id.specialsFragmentContainer);

        Button cartButton = (Button) findViewById(R.id.cartButton);

        if (restaurantFragment == null) {
            restaurantFragment = new RestaurantFragment(restaurantDBModel);
            fragmentManager.beginTransaction().add(R.id.restaurantFragmentContainer, restaurantFragment).commit();
        }

        if (specialsFragment == null) {
            specialsFragment = new SpecialsFragment(foodDBModel);
            fragmentManager.beginTransaction().add(R.id.specialsFragmentContainer, specialsFragment).commit();
        }

        cartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, CartPageActivity.class);
                /*intent.putExtra("foodDBModel", foodDBModel);
                intent.putExtra("cartDBModel", cartDBModel);*/
                startActivity(intent);
            }
        });
    }
}
