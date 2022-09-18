package com.example.mad_assignment_1.databases.orders;

public class OrderDBSchema {
    //TABLE
    public static class orderTable {
        public static final String NAME = "orders";
        //COLUMNS
        public static class Cols {
            public static final String CUSTOMER_ID = "customerId";
            public static final String TIME = "time";
            public static final String DATE = "date";
            public static final String CART_ID = "cart_id";
        }
    }
}
