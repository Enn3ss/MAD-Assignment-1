package com.example.mad_assignment_1.cart_fragments.current_cart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mad_assignment_1.CurrentData;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.food.FoodDBModel;
import com.example.mad_assignment_1.databases.orders.OrderDBModel;
import com.example.mad_assignment_1.order_fragment.OrderListFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrentCartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrentCartFragment extends Fragment {
    CartDBModel cartDBModel;
    FoodDBModel foodDBModel;

    TextView cartIsEmpty;
    Button viewPreviousOrders;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CurrentCartFragment() {
        // Required empty public constructor
    }

    public CurrentCartFragment(CartDBModel cartDBModel, FoodDBModel foodDBModel) {
        this.cartDBModel = cartDBModel;
        this.foodDBModel = foodDBModel;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CurrentCartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrentCartFragment newInstance(String param1, String param2) {
        CurrentCartFragment fragment = new CurrentCartFragment();
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
        View view = inflater.inflate(R.layout.fragment_current_cart, container, false);

        cartIsEmpty = (TextView) view.findViewById(R.id.cartIsEmpty);
        viewPreviousOrders = (Button) view.findViewById(R.id.viewPreviousOrders);

        FoodDBModel foodDBModel = FoodDBModel.getInstance();
        CartDBModel cartDBModel = CartDBModel.getInstance();
        OrderDBModel orderDBModel = OrderDBModel.getInstance();

        RecyclerView recyclerView = view.findViewById(R.id.currentCartRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        CurrentCartAdapter currentCartAdapter = new CurrentCartAdapter(recyclerView, cartIsEmpty);
        recyclerView.setAdapter(currentCartAdapter);

        Cart cart = CurrentData.getCart();

        if (cart.isCartEmpty()) {
            recyclerView.setAlpha(0);
            cartIsEmpty.setAlpha(1);
        }
        else {
            recyclerView.setAlpha(1);
            cartIsEmpty.setAlpha(0);
        }

        viewPreviousOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.cartFragmentContainer, new OrderListFragment()).addToBackStack(null).commit();
            }
        });

        return view;
    }
}