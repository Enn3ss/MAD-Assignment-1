package com.example.mad_assignment_1.databases.orders;

public class OrderDBSchema {
    //TABLE
    public static class orderTable {
        public static final String NAME = "orders";
        //COLUMNS
        public static class Cols {
            public static final String CUSTOMER_ID = "customerId";
            public static final String TIME = "time";
            public static final String TOTAL_COST = "totalCost";
            public static final String FOOD_LIST = "foodList";
        }
    }
}
