package com.example.mad_assignment_1.cart_fragments.previous_cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.mad_assignment_1.R;

public class PreviousCartAdapter extends Adapter<PreviousCartViewHolder> {
    @NonNull
    @Override
    public PreviousCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.previous_cart_view_holder, parent, false);
        return new PreviousCartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreviousCartViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
