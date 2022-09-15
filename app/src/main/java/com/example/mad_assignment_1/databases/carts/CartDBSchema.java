package com.example.mad_assignment_1.databases.carts;

public class CartDBSchema
{
    public static class CartTable // Table
    {
        public static final String NAME = "carts";

        public static class Cols // Columns
        {
            public static final String ID = "cartId";
            public static final String ITEMS = "items";
            public static final String TOTAL_AMOUNT = "totalAmount";
        }
    }
}
