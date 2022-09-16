package com.example.mad_assignment_1.specials_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SpecialsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpecialsListFragment extends Fragment {
    FoodDBModel foodDBModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SpecialsListFragment() {
        // Required empty public constructor
    }

    public SpecialsListFragment(FoodDBModel foodDBModel) {
        this.foodDBModel = foodDBModel;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SpecialsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpecialsListFragment newInstance(String param1, String param2) {
        SpecialsListFragment fragment = new SpecialsListFragment();
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
        View view = inflater.inflate(R.layout.fragment_specials, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.specialsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        SpecialsAdapter specialsAdapter = new SpecialsAdapter(foodDBModel);
        recyclerView.setAdapter(specialsAdapter);
        return view;
    }
}