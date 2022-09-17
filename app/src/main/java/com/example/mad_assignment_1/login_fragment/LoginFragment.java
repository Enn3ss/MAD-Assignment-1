package com.example.mad_assignment_1.login_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mad_assignment_1.CommonData;
import com.example.mad_assignment_1.R;
import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.customers.Customer;
import com.example.mad_assignment_1.databases.customers.CustomerDBModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment
{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2)
    {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        CustomerDBModel customerDBModel = CustomerDBModel.getInstance();
        CartDBModel cartDBModel = CartDBModel.getInstance();
        EditText emailEditText = (EditText) view.findViewById(R.id.emailEditText);
        EditText passwordEditText = (EditText) view.findViewById(R.id.passwordEditText);
        Button loginButton = (Button) view.findViewById(R.id.loginButton);
        Button registerButton = (Button) view.findViewById(R.id.registerButton);

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(customerDBModel.doesCustomerExist(emailEditText.getText().toString())) //if the customer exists
                {
                    Customer newCustomer = new Customer(emailEditText.getText().toString(), passwordEditText.getText().toString(), "cartId");
                    customerDBModel.addCustomer(newCustomer);
                    CommonData.setCurrentCustomer(newCustomer);
                    Toast.makeText(getActivity(), "You have successfully logged in!", Toast.LENGTH_SHORT).show();
                    getActivity().onBackPressed();
                }
                else
                {
                    Toast.makeText(getActivity(), "This account does not exist!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(customerDBModel.doesCustomerExist(emailEditText.getText().toString())) //if the customer exists
                {
                    Toast.makeText(getActivity(), "An account with these credentials already exists!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String newCartId = cartDBModel.getNewCartId();
                    Customer newCustomer = new Customer(emailEditText.getText().toString(), passwordEditText.getText().toString(), newCartId);

                    cartDBModel.addCart(new Cart(newCartId, CommonData.getCart().getItems(), 0.0, newCustomer.getEmail()));

                    customerDBModel.addCustomer(newCustomer);
                    CommonData.setCurrentCustomer(newCustomer);
                    Toast.makeText(getActivity(), "You have successfully registered!", Toast.LENGTH_SHORT).show();
                    getActivity().onBackPressed();
                }
            }
        });

        return view;
    }
}