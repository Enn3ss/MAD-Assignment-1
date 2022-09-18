package com.example.mad_assignment_1.cart_fragments.previous_cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.food.Food;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

import java.util.ArrayList;
import java.util.Arrays;

public class PreviousCartAdapter extends Adapter<PreviousCartViewHolder> {
    CartDBModel cartDBModel = CartDBModel.getInstance();
    FoodDBModel foodDBModel = FoodDBModel.getInstance();
    Cart currentCart;

    public PreviousCartAdapter(Cart currentCart) {
        this.currentCart = currentCart;
    }

    @NonNull
    @Override
    public PreviousCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.previous_cart_view_holder, parent, false);
        return new PreviousCartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreviousCartViewHolder holder, int position) {
        ArrayList<String> items = new ArrayList<>(Arrays.asList(currentCart.getItems().split(",")));
        Food food = foodDBModel.getFoodById(items.get(position));
        holder.bind(food);
    }

    @Override
    public int getItemCount() {
        return currentCart.getSize();
    }
}
