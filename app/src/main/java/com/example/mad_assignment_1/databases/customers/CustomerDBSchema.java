package com.example.mad_assignment_1.databases.customers;

public class CustomerDBSchema {
    //TABLE
    public static class CustomerTable {
        public static final String NAME = "customers";
        //COLUMNS
        public static class Cols {
            public static final String EMAIL = "email";
            public static final String PASSWORD = "password";
            public static final String CART_ID = "cart_id";
        }
    }
}
