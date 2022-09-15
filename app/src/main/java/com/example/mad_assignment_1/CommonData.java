package com.example.mad_assignment_1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CommonData extends ViewModel {
    public MutableLiveData<Integer> value;

    public CommonData() {
        value = new MutableLiveData<Integer>();
        value.setValue(0);
    }

    public int getValue() {
        return value.getValue();
    }

    public void setValue(int value) {
        this.value.setValue(value);
    }
}