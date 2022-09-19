package com.example.mad_assignment_1;

import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.carts.CartDBModel;
import com.example.mad_assignment_1.databases.customers.Customer;
import com.example.mad_assignment_1.databases.customers.CustomerDBModel;
import com.example.mad_assignment_1.databases.food.Food;
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
        if (customer == null) {
            return cart.getSize();
        }
        else {
            return CartDBModel.getInstance().getCartById(customer.getCartId()).getSize();
        }
    }

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(String customerEmail) {
        if (customerEmail == null) {
            customer = null;
            cart = new Cart("", "", "");
        }
        else {
            customer = CustomerDBModel.getInstance().getCustomer(customerEmail);
            cart = null;
        }
    }

    public static boolean isCartEmpty() {
        if (customer == null) {
            return cart.isCartEmpty();
        }
        else {
            return CartDBModel.getInstance().getCartById(customer.getCartId()).isCartEmpty();
        }
    }

    public static void addFoodToCart(String foodId) {
        if (customer == null) {
            cart.addFood(foodId);
        }
        else {
            Cart tempCart = CartDBModel.getInstance().getCartById(customer.getCartId());
            Food tempFood = FoodDBModel.getInstance().getFoodById(foodId);

            CartDBModel.getInstance().addItemToCart(tempCart, tempFood);
        }
    }

    public static void removeFoodFromCart(String foodId) {
        if (customer == null) {
            cart.removeFood(foodId);
        }
        else {
            Cart tempCart = CartDBModel.getInstance().getCartById(customer.getCartId());
            Food tempFood = FoodDBModel.getInstance().getFoodById(foodId);

            CartDBModel.getInstance().removeItemFromCart(tempCart, tempFood);
        }
    }
}