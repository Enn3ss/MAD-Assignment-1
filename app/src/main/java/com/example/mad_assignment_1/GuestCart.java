package com.example.mad_assignment_1;

public class GuestCart {
    private static GuestCart instance = null;

    public static GuestCart getInstance() {
        if (instance == null) {
            instance = new GuestCart();
        }
        return instance;
    }

    String items;
    double totalAmount;

    private GuestCart() {
        this.items = "";
        this.totalAmount = 0;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
