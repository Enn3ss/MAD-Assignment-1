package com.example.mad_assignment_1.databases.carts;

import java.util.ArrayList;
import java.util.Arrays;

public class Cart
{
    String cartId;
    String items;
    double totalAmount;

    public Cart(String cartId, String items, double totalAmount)
    {
        this.cartId = cartId;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public String getCartId() { return cartId; }

    public String getItems() { return items; }

    public double getTotalAmount() { return totalAmount; }

    public void setCartId(String cartId)
    {
        this.cartId = cartId;
    }

    public void addFood(String item)
    {
        if (isCartEmpty()) {
            this.items += item;
        }
        else {
            this.items += "," + item;
        }
    }

    public void removeFood(String item) {
        if (!isCartEmpty()) {
            ArrayList<String> list = new ArrayList<>(Arrays.asList(items.split(",")));
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(item)) {
                    list.remove(i);
                    arrayToString(list);
                    break;
                }
            }
        }
    }

    private void arrayToString(ArrayList<String> list) {
        items = "";
        for (int i = 0; i < list.size(); i++) {
            addFood(list.get(i));
        }
    }

    public void setTotalAmount(double totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public boolean isCartEmpty() {
        boolean isEmpty = false;

        if (items.equals("")) {
            isEmpty = true;
        }
        return isEmpty;
    }
}
