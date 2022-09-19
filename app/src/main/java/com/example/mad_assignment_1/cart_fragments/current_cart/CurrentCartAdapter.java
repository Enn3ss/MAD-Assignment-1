package com.example.mad_assignment_1.cart_fragments.current_cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.mad_assignment_1.CurrentData;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.food.Food;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

import java.util.ArrayList;
import java.util.Arrays;

public class CurrentCartAdapter extends Adapter<CurrentCartViewHolder>
{
    RecyclerView recyclerView;
    TextView cartIsEmpty;

    public CurrentCartAdapter(RecyclerView recyclerView, TextView cartIsEmpty)
    {
        this.recyclerView = recyclerView;
        this.cartIsEmpty = cartIsEmpty;
    }

    @NonNull
    @Override
    public CurrentCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.current_cart_view_holder, parent, false);
        return new CurrentCartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentCartViewHolder holder, int position)
    {
        ArrayList<String> items = new ArrayList<>(Arrays.asList(CurrentData.getCart().getItems().split(",")));

        //if cart is empty
        if (CurrentData.getCart().isCartEmpty()) {
            recyclerView.setAlpha(0);
            cartIsEmpty.setAlpha(1);
        }
        else {
            Food food = FoodDBModel.getInstance().getFoodById(items.get(position));
            holder.bind(food);

            holder.currentCartRemoveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CurrentData.removeFoodFromCart(food.getId());
                    notifyItemRemoved(holder.getBindingAdapterPosition());

                    if (CurrentData.isCartEmpty()) {
                        recyclerView.setAlpha(0);
                        cartIsEmpty.setAlpha(1);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount()
    {
        return CurrentData.getCartSize();
    }
}
