package com.example.mad_assignment_1.databases.food;

public class foodDBSchema {
    //TABLE
    public static class FoodTable {
        public static final String NAME = "foods";
        //COLUMNS
        public static class Cols {
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String PRICE = "price";
            public static final String DESCRIPTION = "description";
            public static final String RESTAURANT_ID = "restaurant_id";
            public static final String IMAGE = "image";
        }
    }
}
