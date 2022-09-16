package com.example.mad_assignment_1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RestaurantViewModel extends ViewModel {
    /*private static RestaurantViewModel instance = null;

    public static RestaurantViewModel getInstance() {
        if (instance == null) {
            instance = new RestaurantViewModel();
        }
        return instance;
    }*/

    public MutableLiveData<String> value;

    public RestaurantViewModel() {
        value = new MutableLiveData<String>();
        value.setValue("");
    }

    public String getValue() {
        return value.getValue();
    }

    public void setValue(String value) {
        this.value.setValue(value);
    }
 }