package com.example.mad_assignment_1.databases.customers;

public class CustomerDBSchema {
    //TABLE
    public static class customerTable {
        public static final String NAME = "customers";
        //COLUMNS
        public static class Cols {
            public static final String ID = "id";
            public static final String FULLNAME = "fullname";
            public static final String EMAIL = "email";
            public static final String PASSWORD = "password";
        }
    }
}
