package com.example.mad_assignment_1.databases.customers;

public class Customer {
    String id;
    String fullName;
    String email;
    String password;
    String cartId;

    public Customer(String id, String fullName, String email, String password, String cartId) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.cartId = cartId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
}