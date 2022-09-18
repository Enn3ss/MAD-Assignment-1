package com.example.mad_assignment_1;

import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.customers.Customer;
import com.example.mad_assignment_1.databases.customers.CustomerDBModel;

public class CommonData {
    private static Cart currentCart = new Cart("", "", "");
    private static Customer currentCustomer = null; // If null then there is no customer currently logged in

    public static Cart getCurrentCart() {
        return currentCart;
    }

    public static int getCartSize() {
        return currentCart.getSize();
    }

    public static Customer getCustomer() {
        return currentCustomer;
    }

    public static void setCurrentCustomer(Customer newCustomer) {

        if (newCustomer == null) {
            currentCustomer = null;
            currentCart = new Cart("", "", "");
        }
        else {
            currentCustomer = newCustomer;
            currentCart = CartDBModel.getInstance().getCartById(newCustomer.getCartId());
        }
    }

    public static boolean isCartEmpty() {
        return currentCart.isCartEmpty();
    }

    // Once a customer "makes purchase" their cart will reset and be empty again
    public static void updateCart() {
        currentCart = CartDBModel.getInstance().getCartById(currentCustomer.getCartId());
    }
}