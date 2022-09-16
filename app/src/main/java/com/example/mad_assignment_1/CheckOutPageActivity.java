package com.example.mad_assignment_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.mad_assignment_1.login_fragment.LoginFragment;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mad_assignment_1.databinding.ActivityCheckOutPageBinding;

public class CheckOutPageActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_page);

        if(CommonData.getCustomer() == null)
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