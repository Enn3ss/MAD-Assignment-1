package com.example.mad_assignment_1.cart_fragments.previous_cart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.carts.CartDBModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PreviousCartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreviousCartFragment extends Fragment {
    CartDBModel cartDBModel;
    String currentCart;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PreviousCartFragment() {
        // Required empty public constructor
    }

    public PreviousCartFragment(String currentCart) {
        this.cartDBModel = CartDBModel.getInstance();
        this.currentCart = currentCart;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PreviousCartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PreviousCartFragment newInstance(String param1, String param2) {
        PreviousCartFragment fragment = new PreviousCartFragment();
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
        View view = inflater.inflate(R.layout.fragment_previous_cart, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.previousCartRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        PreviousCartAdapter previousCartAdapter = new PreviousCartAdapter(currentCart);
        recyclerView.setAdapter(previousCartAdapter);

        return view;
    }
}