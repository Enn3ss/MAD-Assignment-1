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

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
}