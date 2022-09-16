package com.example.mad_assignment_1.specials_fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.food.Food;

public class SpecialsViewHolder extends ViewHolder {
    ImageView specialIcon;
    TextView specialName;
    TextView foodDescription;

    public SpecialsViewHolder(@NonNull View view) {
        super(view);
        specialIcon = (ImageView) view.findViewById(R.id.specialIcon);
        specialName = (TextView) view.findViewById(R.id.specialName);
        //foodDescription = (TextView) view.findViewById(R.id.foodDescription);
    }

    public void bind(Food food) {
        specialIcon.setImageResource(food.getImage());
        specialName.setText(food.getName());
        //foodDescription.setText(food.getDescription());
    }
}
