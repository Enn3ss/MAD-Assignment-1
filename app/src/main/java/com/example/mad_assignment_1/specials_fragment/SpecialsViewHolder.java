package com.example.mad_assignment_1.specials_fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.food.Food;

public class SpecialsViewHolder extends ViewHolder {
    ImageView foodIcon;
    TextView foodName;
    TextView foodDescription;

    public SpecialsViewHolder(@NonNull View view) {
        super(view);
        foodIcon = (ImageView) view.findViewById(R.id.foodIcon);
        foodName = (TextView) view.findViewById(R.id.foodName);
        //foodDescription = (TextView) view.findViewById(R.id.foodDescription);
    }

    public void bind(Food food) {
        foodIcon.setImageResource(food.getImage());
        foodName.setText(food.getName());
        //foodDescription.setText(food.getDescription());
    }
}
