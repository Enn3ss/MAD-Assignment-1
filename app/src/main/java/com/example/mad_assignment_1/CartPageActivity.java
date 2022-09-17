package com.example.mad_assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

import com.example.mad_assignment_1.cart_recycler_view.CartItemAdapter;
import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

public class CartPageActivity extends AppCompatActivity
{
    TextView cartIsEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_page);

        cartIsEmpty = (TextView) findViewById(R.id.cartIsEmpty);

        FoodDBModel foodDBModel = FoodDBModel.getInstance();
        CartDBModel cartDBModel = CartDBModel.getInstance();

        RecyclerView rv = findViewById(R.id.recView);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        CartItemAdapter adapter = new CartItemAdapter(cartDBModel, foodDBModel, rv, cartIsEmpty);
        rv.setAdapter(adapter);

        Cart cart;

        if (CommonData.getCustomer() == null) { //if no customer is logged in (guest)
            System.out.println("if " + CommonData.getCart().getCartId());
            cart = CommonData.getCart();
        }
        else { //if customer is logged in
            System.out.println("else " + CommonData.getCustomer().getCartId());
            cart = cartDBModel.getCartById(CommonData.getCustomer().getCartId());
        }

        if (cart.isCartEmpty()) {
            rv.setAlpha(0);
            cartIsEmpty.setAlpha(1);
        }
        else {
            rv.setAlpha(1);
            cartIsEmpty.setAlpha(0);
        }
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, CartPageActivity.class);
        return intent;
    }
}