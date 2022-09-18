package com.example.mad_assignment_1.order_fragment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.orders.Order;

public class OrderViewHolder extends RecyclerView.ViewHolder {
    TextView totalPriceTextView;
    TextView dateTextView;
    TextView timeTextView;

    public OrderViewHolder(@NonNull View view) {
        super(view);
        totalPriceTextView = (TextView) view.findViewById(R.id.totalPriceTextView);
        dateTextView = (TextView) view.findViewById(R.id.dateTextView);
        timeTextView = (TextView) view.findViewById(R.id.timeTextView);
    }

    public void bind(Order order) {
        // gets CartDBModel and gets the cart of the parameter order.
        String totalPrice = Double.toString(CartDBModel.getInstance().getCartById(order.getCartId()).getTotalAmount());
        totalPriceTextView.setText(totalPrice);
        dateTextView.setText(order.getDate());
        timeTextView.setText(order.getTime());
    }
}
