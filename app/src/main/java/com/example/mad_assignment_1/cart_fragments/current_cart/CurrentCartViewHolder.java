package com.example.mad_assignment_1.cart_fragments.current_cart;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.food.Food;

public class CurrentCartViewHolder extends ViewHolder
{
    ImageView currentCartItemIcon;
    TextView currentCartItemName;
    Button currentCartRemoveButton;

    public CurrentCartViewHolder(@NonNull View itemView)
    {
        super(itemView);

        currentCartItemIcon = (ImageView) itemView.findViewById(R.id.currentCartItemIcon);
        currentCartItemName = (TextView) itemView.findViewById(R.id.name);
        currentCartRemoveButton = (Button) itemView.findViewById(R.id.currentCartRemoveButton);
    }

    public void bind(Food food)
    {
        currentCartItemIcon.setImageResource(food.getImage());
        currentCartItemName.setText(food.getName());
    }
}
