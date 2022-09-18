package com.example.mad_assignment_1.order_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.mad_assignment_1.OrderViewModel;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.activities.CartPageActivity;
import com.example.mad_assignment_1.databases.orders.Order;
import com.example.mad_assignment_1.databases.orders.OrderDBModel;

import java.util.ArrayList;

public class OrderAdapter extends Adapter<OrderViewHolder> {
    OrderDBModel orderDBModel;
    OrderViewModel orderViewModel;

    public OrderAdapter(OrderDBModel orderDBModel) {
        this.orderDBModel = orderDBModel;
        this.orderViewModel = new ViewModelProvider(CartPageActivity.getInstance()).get(OrderViewModel.class);
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.order_view_holder, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        int currPosition = position;
        ArrayList<Order> orders = orderDBModel.getAllOrders();
        holder.bind(orders.get(position));

        holder.totalPriceTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderViewModel.setValue(orders.get(currPosition).getCartId());
            }
        });

        holder.dateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderViewModel.setValue(orders.get(currPosition).getCartId());
            }
        });

        holder.timeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderViewModel.setValue(orders.get(currPosition).getCartId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderDBModel.getSize();
    }
}
