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

    public Cart(String cartId, String items, String customerId)
    {
        this.cartId = cartId;
        this.items = items;
        this.totalAmount = 0;
        this.customerEmail = customerId;
    }

    public Cart(String cartId, String items, double totalAmount, String customerId)
    {
        this.cartId = cartId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.customerEmail = customerId;
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
            this.items += foodId;
        }
        else {
            this.items += "," + foodId;
        }
        totalAmount += FoodDBModel.getInstance().getFoodById(foodId).getPrice();
    }

    public void removeFood(String item) {
        if (!isCartEmpty()) {
            ArrayList<String> list = new ArrayList<>(Arrays.asList(items.split(",")));
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(item)) {
                    list.remove(i);
                    break;
                }
            }
            items = "";
            for (int i = 0; i < list.size(); i++) {
                addFood(list.get(i));
            }
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
