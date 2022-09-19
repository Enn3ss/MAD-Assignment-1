package com.example.mad_assignment_1.databases.customers;

public class Customer {
    String email;
    String password;
    String cartId;

    public Customer(String email, String password, String cartId) {
        this.email = email;
        this.password = password;
        this.cartId = cartId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
}