package com.example.mad_assignment_1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.mad_assignment_1.OrderViewModel;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.cart_fragments.current_cart.CurrentCartFragment;
import com.example.mad_assignment_1.cart_fragments.previous_cart.PreviousCartFragment;

public class CartPageActivity extends AppCompatActivity
{
    private static CartPageActivity instance = null;
    public static CartPageActivity getInstance() {
        return instance;
    }

    OrderViewModel orderViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_page);

        instance = this;

        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);

        CurrentCartFragment currentCartFragment = new CurrentCartFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.cartFragmentContainer, currentCartFragment).setReorderingAllowed(true).commit();

        orderViewModel.value.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String value) {
                if (!value.equals("")) {
                    PreviousCartFragment previousCartFragment = new PreviousCartFragment(value);
                    fragmentManager.beginTransaction().replace(R.id.cartFragmentContainer, previousCartFragment).addToBackStack(null).commit();
                }
            }
        });
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, CartPageActivity.class);
        return intent;
    }
}