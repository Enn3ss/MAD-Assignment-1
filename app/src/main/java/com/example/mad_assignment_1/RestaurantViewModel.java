package com.example.mad_assignment_1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RestaurantViewModel extends ViewModel {
    public MutableLiveData<String> value;

    public RestaurantViewModel() {
        value = new MutableLiveData<String>();
        value.setValue("");
    }

    public void setValue(String value) {
        this.value.setValue(value);
    }
 }