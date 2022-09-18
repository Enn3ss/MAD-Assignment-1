package com.example.mad_assignment_1;

import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.customers.Customer;
import com.example.mad_assignment_1.databases.food.FoodDBModel;

public class CurrentData {
    private static Cart cart = new Cart("", "", "");
    private static Customer customer = null; // If null then there is no customer currently logged in

    public static Cart getCart() {
        if (customer == null) {
            return cart;
        }
        else {
            return CartDBModel.getInstance().getCartById(customer.getCartId());
        }
    }

    public static int getCartSize() {
        return cart.getSize();
    }

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer newCustomer) {

        if (newCustomer == null) {
            customer = null;
            cart = new Cart("", "", "");
        }
        else {
            customer = newCustomer;
            cart = CartDBModel.getInstance().getCartById(newCustomer.getCartId());
        }
    }

    public static boolean isCartEmpty() {
        return cart.isCartEmpty();
    }

    // Once a customer "makes purchase" their cart will reset and be empty again
    public static void updateCart() {
        cart = CartDBModel.getInstance().getCartById(customer.getCartId());
    }

    public static void addFoodToCart(String foodId) {
        cart.addFood(foodId);
        if (customer != null) {
            CartDBModel.getInstance().addItemToCart(cart, FoodDBModel.getInstance().getFoodById(foodId));
        }
    }

    public static void removeFoodFromCart(String foodId) {
        //TODO
    }
}