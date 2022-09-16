package com.example.mad_assignment_1;

import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.customers.Customer;

public class CommonData {
    private static Cart guestCart = new Cart("", "", 0.0);
    private static Customer currentCustomer = null; // If null then there is no customer currently logged in

    public static Cart getCart() {
        return guestCart;
    }

    public static void addCartItem(String input) {
        guestCart.setItems(input);
    }

    public static void setCartTotalPrice(double input) {
        guestCart.setTotalAmount(input);
    }

    public static Customer getCustomer() {
        return currentCustomer;
    }

    public static void setCurrentCustomer(Customer input) {
        currentCustomer = input;
    }
}
