package com.example.mad_assignment_1.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_assignment_1.CurrentData;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.checkout_recycler_view.CheckoutAdapter;
import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.food.FoodDBModel;
import com.example.mad_assignment_1.databases.orders.Order;
import com.example.mad_assignment_1.databases.orders.OrderDBModel;
import com.example.mad_assignment_1.login_fragment.LoginFragment;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CheckoutPageActivity extends AppCompatActivity
{
    private Button purchaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_page);

        purchaseButton = (Button) findViewById(R.id.purchaseButton);

        if(CurrentData.getCustomer() == null) // Check if customer is already logged in
        {
            purchaseButton.setAlpha(0);
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
        OrderDBModel orderDBModel = OrderDBModel.getInstance();
        CartDBModel cartDBModel = CartDBModel.getInstance();
        CheckoutAdapter adapter = new CheckoutAdapter(foodDBModel);
        rv.setAdapter(adapter);

        purchaseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(CurrentData.isCartEmpty()) // User cannot make purchase if cart is empty
                {
                    Toast.makeText(getApplicationContext(), "Cannot make purchase on empty cart!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // get current time and date
                    String time = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                    String date = new SimpleDateFormat("HH:mm:ss").format(new Date());

                    // create order
                    Order order = new Order(CurrentData.getCustomer().getEmail(), time, date, CurrentData.getCart().getCartId());
                    orderDBModel.addOrder(order);

                    // create new cart
                    Cart newCart = new Cart(cartDBModel.getNewCartId(), "", CurrentData.getCustomer().getEmail());
                    cartDBModel.addCart(newCart);

                    CurrentData.getCustomer().setCartId(newCart.getCartId());

                    Toast.makeText(getApplicationContext(), "Purchase made. Your order is on its way!", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }

    public static Intent getIntent(Context context)
    {
        return new Intent(context, CheckoutPageActivity.class);
    }
}