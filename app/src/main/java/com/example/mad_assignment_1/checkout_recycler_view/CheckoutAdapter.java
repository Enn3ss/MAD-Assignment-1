package com.example.mad_assignment_1.checkout_recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_assignment_1.CommonData;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.food.Food;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutViewHolder>
{
    private FoodDBModel foodDBModel;

    public CheckoutAdapter(FoodDBModel foodDBModel)
    {
        this.foodDBModel = foodDBModel;
    }

    @NonNull
    @Override
    public CheckoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View v = li.inflate(R.layout.each_checkout_item_view, parent, false);

        return new CheckoutViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutViewHolder holder, int position)
    {
        Cart cart = CommonData.getCart();
        ArrayList<String> items = new ArrayList<>(Arrays.asList(cart.getItems().split(",")));

        if (!items.get(position).equals(""))
        {
            Food food = foodDBModel.getFoodById(items.get(position));
            holder.bind(food);
        }
    }

    @Override
    public int getItemCount()
    {
        return CommonData.getCartSize();
    }
}
