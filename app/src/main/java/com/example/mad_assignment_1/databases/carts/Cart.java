package com.example.mad_assignment_1.databases.carts;

import com.example.mad_assignment_1.databases.food.FoodDBModel;

import java.util.ArrayList;
import java.util.Arrays;

public class Cart
{
    String cartId;
    String items;
    double totalAmount;
    String customerEmail;

    public Cart(String cartId, String items, String customerEmail)
    {
        this.cartId = cartId;
        this.items = items;
        this.totalAmount = 0.0;
        this.customerEmail = customerEmail;
    }

    public Cart(String cartId, String items, double totalAmount, String customerEmail)
    {
        this.cartId = cartId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.customerEmail = customerEmail;
    }

    public String getCartId() { return cartId; }

    public String getItems() { return items; }

    public double getTotalAmount() { return totalAmount; }

    public String getCustomerEmail() { return customerEmail; }

    public void setCartId(String cartId)
    {
        this.cartId = cartId;
    }

    public void setTotalAmount(double totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public void setFoodItems(String items) {
        this.items = items;
    }

    public void addFood(String foodId)
    {
        if (isCartEmpty()) {
            items += foodId;
        }
        else {
            items += "," + foodId;
        }
        totalAmount += FoodDBModel.getInstance().getFoodById(foodId).getPrice();
    }

    public void removeFood(String foodId) {
        if (!isCartEmpty()) {
            // if the first id in items is equal to foodId
            if (String.valueOf(items.charAt(0)).equals(foodId)) {
                // if items has more than 1 id in it
                if (items.length() > 1) {
                    // remove the first id and the comma following it
                    items = items.substring(2);
                }
                else {
                    // set items to empty as the only id was removed
                    items = "";
                }
            }
            // if the first id is not equal to foodId
            else {
                items = items.replaceFirst("," + foodId, "");
            }
            totalAmount -= FoodDBModel.getInstance().getFoodById(foodId).getPrice();
        }
    }

    public boolean isCartEmpty() {
        boolean isEmpty = false;

        if (items.equals("")) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public int getSize() {
        int count = 0;
        String[] itemsArray = items.split(",");

        for (int i = 0; i < itemsArray.length; i++) {
            count += 1;
        }
        return count;
    }
}
