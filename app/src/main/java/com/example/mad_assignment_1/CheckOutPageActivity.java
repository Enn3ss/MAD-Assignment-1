package com.example.mad_assignment_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mad_assignment_1.databinding.ActivityCheckOutPageBinding;

public class CheckOutPageActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityCheckOutPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_page);
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, CheckOutPageActivity.class);
        return intent;
    }
}