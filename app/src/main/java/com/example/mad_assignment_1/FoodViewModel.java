package com.example.mad_assignment_1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FoodViewModel extends ViewModel {
    public MutableLiveData<String> value;

    public FoodViewModel() {
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
