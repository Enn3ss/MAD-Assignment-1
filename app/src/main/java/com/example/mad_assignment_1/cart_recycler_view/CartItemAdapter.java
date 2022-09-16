package com.example.mad_assignment_1.cart_recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.food.Food;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

import java.util.ArrayList;
import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemViewHolder>
{
    CartDBModel cartDBModel;
    FoodDBModel foodDBModel;

    public CartItemAdapter(CartDBModel cartDBModel, FoodDBModel foodDBModel)
    {
        this.cartDBModel = cartDBModel;
        this.foodDBModel = foodDBModel;
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View v = li.inflate(R.layout.each_cart_item_view, parent, false);
        return new CartItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, int position)
    {
        //String test = "1,2,3,4";

        //Cart cart = cartDBModel.getCartById("");

        Cart cart = new Cart("", "1,5,7", 0.0);
        cartDBModel.addCart(cart);

        String items = cart.getItems();
        String[] foods = items.split(",");
        holder.bind(foodDBModel.getFoodById(foods[position]));
        //holder.bind(new Food("2", "food", 50.0, "yum yum", "2", R.drawable.brownie_icon));
    }

    @Override
    public int getItemCount()
    {
        return 3;
    }
}
