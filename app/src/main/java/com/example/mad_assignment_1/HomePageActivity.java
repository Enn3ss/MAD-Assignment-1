package com.example.mad_assignment_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.food.FoodDBModel;
import com.example.mad_assignment_1.databases.restaurants.RestaurantDBModel;
import com.example.mad_assignment_1.food_fragment.FoodListFragment;
import com.example.mad_assignment_1.restaurants_fragment.RestaurantListFragment;
import com.example.mad_assignment_1.specials_fragment.SpecialsListFragment;

public class HomePageActivity extends AppCompatActivity {
    private static HomePageActivity instance = null;
    public static HomePageActivity getInstance() {
        return instance;
    }

    RestaurantViewModel restaurantViewModel;
    FoodViewModel foodViewModel;

    FoodListFragment foodListFragment;
    FoodItemFragment foodItemFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        instance = this;

        Button cartButton = (Button) findViewById(R.id.cartButton);
        Button checkOutButton = (Button) findViewById(R.id.checkoutButton);

        //Create Restaurants ViewModel.
        restaurantViewModel = new ViewModelProvider(this).get(RestaurantViewModel.class);
        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);

        RestaurantDBModel restaurantDBModel = new RestaurantDBModel();
        restaurantDBModel.load(getApplicationContext());

        FoodDBModel foodDBModel = FoodDBModel.getInstance();
        foodDBModel.load(getApplicationContext());

        CartDBModel cartDBModel = CartDBModel.getInstance();
        cartDBModel.load(getApplicationContext());

        SpecialsListFragment specialsListFragment = new SpecialsListFragment(foodDBModel);
        RestaurantListFragment restaurantListFragment = new RestaurantListFragment(restaurantDBModel);

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.specialsFragmentContainer, specialsListFragment).commit();

        fragmentManager.beginTransaction().add(R.id.menuFragmentContainer, restaurantListFragment).setReorderingAllowed(true).commit();

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(CartPageActivity.getIntent(HomePageActivity.this));
            }
        });

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(CheckOutPageActivity.getIntent(HomePageActivity.this));
            }
        });

        restaurantViewModel.value.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String value) {
                if (!value.equals("")) {
                    foodListFragment = new FoodListFragment(foodDBModel, value);
                    fragmentManager.beginTransaction().replace(R.id.menuFragmentContainer, foodListFragment).addToBackStack(null).commit();
                    restaurantViewModel.setValue("");
                }
            }
        });

        foodViewModel.value.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String value) {
                if (!value.equals("")) {
                    foodItemFragment = new FoodItemFragment(foodDBModel, value);
                    fragmentManager.beginTransaction().replace(R.id.menuFragmentContainer, foodItemFragment).addToBackStack(null).commit();
                    foodViewModel.setValue("");
                }
            }
        });
    }
}