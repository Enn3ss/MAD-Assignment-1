package com.example.mad_assignment_1.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mad_assignment_1.CurrentData;
import com.example.mad_assignment_1.FoodViewModel;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.RestaurantViewModel;
import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.customers.CustomerDBModel;
import com.example.mad_assignment_1.databases.food.FoodDBModel;
import com.example.mad_assignment_1.databases.orders.OrderDBModel;
import com.example.mad_assignment_1.databases.restaurants.RestaurantDBModel;
import com.example.mad_assignment_1.food_fragment.FoodListFragment;
import com.example.mad_assignment_1.food_item_fragment.FoodItemFragment;
import com.example.mad_assignment_1.restaurants_fragment.RestaurantListFragment;
import com.example.mad_assignment_1.specials_fragment.SpecialsListFragment;

public class HomePageActivity extends AppCompatActivity {
    private static HomePageActivity instance = null;
    public static HomePageActivity getInstance() {
        return instance;
    }

    RestaurantViewModel restaurantViewModel;
    FoodViewModel foodViewModel;
    FoodListFragment foodFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        instance = this;

        Button cartButton = (Button) findViewById(R.id.cartButton);
        Button checkOutButton = (Button) findViewById(R.id.checkoutButton);
        Button logoutButton = (Button) findViewById(R.id.logoutButton);

        restaurantViewModel = new ViewModelProvider(this).get(RestaurantViewModel.class);
        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);

        RestaurantDBModel restaurantDBModel = new RestaurantDBModel();
        restaurantDBModel.load(getApplicationContext());

        FoodDBModel foodDBModel = FoodDBModel.getInstance();
        foodDBModel.load(getApplicationContext());

        CartDBModel cartDBModel = CartDBModel.getInstance();
        cartDBModel.load(getApplicationContext());

        CustomerDBModel customerDBModel = CustomerDBModel.getInstance();
        customerDBModel.load(getApplicationContext());

        OrderDBModel orderDBModel = OrderDBModel.getInstance();
        orderDBModel.load(getApplicationContext());

        SpecialsListFragment specialsFragment = new SpecialsListFragment(foodDBModel);
        RestaurantListFragment restaurantFragment = new RestaurantListFragment(restaurantDBModel);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.specialsFragmentContainer, specialsFragment).commit();
        fragmentManager.beginTransaction().add(R.id.menuFragmentContainer, restaurantFragment).setReorderingAllowed(true).commit();

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(CartPageActivity.getIntent(HomePageActivity.this));
            }
        });

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(CheckoutPageActivity.getIntent(HomePageActivity.this));
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CurrentData.getCustomer() == null)
                {
                    Toast.makeText(HomePageActivity.this, "You are not logged in!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    CurrentData.setCustomer(null);
                    Toast.makeText(HomePageActivity.this, "You have logged out!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        restaurantViewModel.value.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String value) {
                if (!value.equals("")) {
                    FoodListFragment foodListFragment = new FoodListFragment(value);
                    fragmentManager.beginTransaction().replace(R.id.menuFragmentContainer, foodListFragment).addToBackStack(null).commit();
                }
            }
        });

        foodViewModel.value.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String value) {
                if (!value.equals("")) {
                    FoodItemFragment foodItemFragment = new FoodItemFragment(value);
                    fragmentManager.beginTransaction().replace(R.id.menuFragmentContainer, foodItemFragment).addToBackStack(null).commit();
                }
            }
        });
    }
}