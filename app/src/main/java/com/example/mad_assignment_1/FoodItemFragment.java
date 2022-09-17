package com.example.mad_assignment_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_assignment_1.databases.food.Food;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodItemFragment extends Fragment {
    FoodDBModel foodDBModel;
    String selectedFoodItem;

    ImageView foodItemIcon;
    TextView foodItemName;
    TextView foodItemPrice;
    TextView foodItemDescription;
    Button subtractButton;
    EditText foodItemAmount;
    Button addButton;
    Button addToCart;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodItemFragment() {
        // Required empty public constructor
    }

    public FoodItemFragment(FoodDBModel foodDBModel, String selectedFoodItem) {
        this.foodDBModel = foodDBModel;
        this.selectedFoodItem = selectedFoodItem;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodItemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodItemFragment newInstance(String param1, String param2) {
        FoodItemFragment fragment = new FoodItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_item, container, false);

        foodItemIcon = (ImageView) view.findViewById(R.id.foodItemIcon);
        foodItemName = (TextView) view.findViewById(R.id.foodItemName);
        foodItemPrice = (TextView) view.findViewById(R.id.foodItemPrice);
        foodItemDescription = (TextView) view.findViewById(R.id.foodItemDescription);
        subtractButton = (Button) view.findViewById(R.id.subtractButton);
        foodItemAmount = (EditText) view.findViewById(R.id.foodItemAmount);
        addButton = (Button) view.findViewById(R.id.addButton);
        addToCart = (Button) view.findViewById(R.id.addToCart);

        Food food = foodDBModel.getFoodById(selectedFoodItem);

        foodItemIcon.setImageResource(food.getImage());
        foodItemName.setText(food.getName());
        foodItemPrice.setText("$" + Double.toString(food.getPrice()));
        foodItemDescription.setText(food.getDescription());
        foodItemAmount.setText("1");

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int amount = Integer.parseInt(foodItemAmount.getText().toString());
                if (amount > 1) {
                    amount -= 1;
                    foodItemAmount.setText(Integer.toString(amount));
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int amount = Integer.parseInt(foodItemAmount.getText().toString());
                amount += 1;
                foodItemAmount.setText(Integer.toString(amount));
            }
        });

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < Integer.parseInt(foodItemAmount.getText().toString()); i++) {
                    CommonData.getCurrentCart().addFood(food.getId());
                }
                Toast.makeText(getActivity(), foodItemAmount.getText().toString() + "x " + food.getName() + " has been added to cart", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}