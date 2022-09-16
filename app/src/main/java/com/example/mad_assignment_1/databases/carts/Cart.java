package com.example.mad_assignment_1.databases.carts;

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

    public void setItems(String item)
    {
        this.items += "," + item;
    }

    public void setTotalAmount(double totalAmount)
    {
        this.totalAmount = totalAmount;
    }
}
