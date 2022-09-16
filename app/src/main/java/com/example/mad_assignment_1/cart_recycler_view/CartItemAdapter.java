package com.example.mad_assignment_1.cart_recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_assignment_1.CommonData;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.food.Food;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemViewHolder>
{
    CartDBModel cartDBModel;
    FoodDBModel foodDBModel;
    RecyclerView recyclerView;

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
        int currPosition = position;
        Cart cart = CommonData.getCart();
        String[] items = cart.getItems().split(",");

        System.out.println(items[position]);

        if (!items[position].equals("")) {
            Food food = foodDBModel.getFoodById(items[position]);
            holder.bind(food);

            holder.removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cart.removeFood(food.getId());
                    notifyItemRemoved(currPosition);
                    notifyItemRangeChanged(currPosition, CommonData.getCartSize());
                    recyclerView.setAlpha(0);
                    recyclerView.findViewById(R.id.cartIsEmpty).setAlpha(1);
                }
            });
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        this.recyclerView = recyclerView;
    }

    @Override
    public int getItemCount()
    {
        return CommonData.getCartSize();
    }
}
