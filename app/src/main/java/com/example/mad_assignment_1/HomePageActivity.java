package com.example.mad_assignment_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.food.FoodDBModel;
import com.example.mad_assignment_1.databases.restaurants.RestaurantDBModel;
import com.example.mad_assignment_1.food_fragment.FoodFragment;
import com.example.mad_assignment_1.restaurants_fragment.RestaurantFragment;
import com.example.mad_assignment_1.specials_fragment.SpecialsFragment;

public class HomePageActivity extends AppCompatActivity {
    private static HomePageActivity instance = null;
    public static HomePageActivity getInstance() {
        return instance;
    }

    private RestaurantViewModel restaurantViewModel;
    private FoodFragment foodFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        instance = this;

        Button cartButton = (Button) findViewById(R.id.cartButton);
        Button checkOutButton = (Button) findViewById(R.id.checkoutButton);
        Button logoutButton = (Button) findViewById(R.id.logoutButton);

        //Create Restaurants ViewModel.
        restaurantViewModel = new ViewModelProvider(this).get(RestaurantViewModel.class);

        RestaurantDBModel restaurantDBModel = new RestaurantDBModel();
        restaurantDBModel.load(getApplicationContext());

        FoodDBModel foodDBModel = FoodDBModel.getInstance();
        foodDBModel.load(getApplicationContext());

        CartDBModel cartDBModel = CartDBModel.getInstance();
        cartDBModel.load(getApplicationContext());

        SpecialsFragment specialsFragment = new SpecialsFragment(foodDBModel);
        RestaurantFragment restaurantFragment = new RestaurantFragment(restaurantDBModel);

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
                startActivity(CheckOutPageActivity.getIntent(HomePageActivity.this));
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonData.setCurrentCustomer(null);
                Toast.makeText(HomePageActivity.this, "You have logged out!", Toast.LENGTH_SHORT).show();
            }
        });

        restaurantViewModel.value.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String string) {
                if (!string.equals("")) {
                    foodFragment = new FoodFragment(foodDBModel, string);
                    fragmentManager.beginTransaction().replace(R.id.menuFragmentContainer, foodFragment).addToBackStack(null).commit();
                    restaurantViewModel.setValue("");
                }
            }
        });
    }
}