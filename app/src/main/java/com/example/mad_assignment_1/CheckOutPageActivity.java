package com.example.mad_assignment_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.mad_assignment_1.login_fragment.LoginFragment;


public class CheckOutPageActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_page);

        if(CommonData.getCustomer() == null) // Check if customer is already logged in
        {
            FragmentManager fm = getSupportFragmentManager();
            LoginFragment loginFragment = (LoginFragment) fm.findFragmentById(R.id.loginFragmentContainer);

            if(loginFragment == null)
            {
                loginFragment = new LoginFragment();
                fm.beginTransaction().add(R.id.loginFragmentContainer, loginFragment).commit();
            }
        }
    }

    public static Intent getIntent(Context context)
    {
        return new Intent(context, CheckOutPageActivity.class);
    }
}