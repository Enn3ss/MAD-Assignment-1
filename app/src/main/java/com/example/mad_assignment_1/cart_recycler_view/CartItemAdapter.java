package com.example.mad_assignment_1.cart_recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

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

        //Cart cart = cartDBModel.getCartById(test);
        //String items = cart.getItems();
        //String[] foods = items.split(",");
        String[] foods = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" };
        holder.bind(foodDBModel.getFoodById(foods[position]));
    }

    @Override
    public int getItemCount()
    {
        return cartDBModel.getSize();
    }
}
