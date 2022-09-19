package com.example.mad_assignment_1.order_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.mad_assignment_1.CurrentData;
import com.example.mad_assignment_1.OrderViewModel;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.activities.CartPageActivity;
import com.example.mad_assignment_1.databases.orders.Order;
import com.example.mad_assignment_1.databases.orders.OrderDBModel;

import java.util.ArrayList;

public class OrderAdapter extends Adapter<OrderViewHolder> {
    OrderViewModel orderViewModel;

    TextView noPreviousOrders;

    public OrderAdapter(TextView noPreviousOrders) {
        this.orderViewModel = new ViewModelProvider(CartPageActivity.getInstance()).get(OrderViewModel.class);
        this.noPreviousOrders = noPreviousOrders;
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
        if (CurrentData.getCustomer() != null) {
            ArrayList<Order> orders = OrderDBModel.getInstance().getOrdersFrom(CurrentData.getCustomer().getEmail());
            if (orders.isEmpty()) {
                noPreviousOrders.setAlpha(1);
            }
            else {
                noPreviousOrders.setAlpha(0);
                holder.bind(orders.get(position));

                holder.totalPriceTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        orderViewModel.setValue(orders.get(holder.getBindingAdapterPosition()).getCartId());
                    }
                });

                holder.dateTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        orderViewModel.setValue(orders.get(holder.getBindingAdapterPosition()).getCartId());
                    }
                });

                holder.timeTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        orderViewModel.setValue(orders.get(holder.getBindingAdapterPosition()).getCartId());
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        if (CurrentData.getCustomer() == null) {
            return 0;
        }
        else {
            return OrderDBModel.getInstance().getSizeFrom(CurrentData.getCustomer().getEmail());
        }
    }
}
