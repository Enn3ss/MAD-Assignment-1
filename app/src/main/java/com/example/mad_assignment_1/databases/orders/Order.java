package com.example.mad_assignment_1.databases.orders;

public class Order {
    String customerId;
    String time;
    String date;
    String cartId;

    public Order(String customerId, String time, String date, String cartId) {
        this.customerId = customerId;
        this.time = time;
        this.date = date;
        this.cartId = cartId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getCartId() {
        return cartId;
    }
}