package com.example.mad_assignment_1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_assignment_1.checkout_recycler_view.CheckoutAdapter;
import com.example.mad_assignment_1.databases.food.FoodDBModel;
import com.example.mad_assignment_1.login_fragment.LoginFragment;


public class CheckoutPageActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_page);

        if(CommonData.getCustomer() == null) // Check if customer is already logged in
        {
            FragmentManager fm = getSupportFragmentManager();
            LoginFragment loginFragment = (LoginFragment) fm.findFragmentById(R.id.loginFragmentContainer);

            if(loginFragment == null)
            {
                loginFragment = new LoginFragment();
                fm.beginTransaction().add(R.id.loginFragmentContainer, loginFragment).commit();
            }
        }

        RecyclerView rv = findViewById(R.id.checkoutRecView);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        FoodDBModel foodDBModel = FoodDBModel.getInstance();
        CheckoutAdapter adapter = new CheckoutAdapter(foodDBModel);
        rv.setAdapter(adapter);
    }

    public static Intent getIntent(Context context)
    {
        return new Intent(context, CheckoutPageActivity.class);
    }
}