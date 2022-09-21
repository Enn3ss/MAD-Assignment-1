package com.example.mad_assignment_1.databases.carts;

import com.example.mad_assignment_1.databases.food.FoodDBModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            // if there is more than 1 id in items
            if (items.contains(",")) {
                // get the first id
                String firstItem = items.substring(items.indexOf(items.charAt(0)), items.indexOf(","));
                //if the first id is equal to foodId
                if (firstItem.equals(foodId)) {
                    // remove the first id plus the ","
                    items = items.replaceFirst(firstItem + ",", "");
                }
                else {
                    // remove the foodId plus the "," before it
                    items = items.replaceFirst("," + foodId, "");
                }
            }
            else {
                if (items.equals(foodId)) {
                    items = "";
                }
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
