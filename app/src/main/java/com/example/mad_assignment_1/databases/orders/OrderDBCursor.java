package com.example.mad_assignment_1.databases.orders;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.mad_assignment_1.databases.food.Food;
import com.example.mad_assignment_1.databases.orders.OrderDBSchema.orderTable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class OrderDBCursor extends CursorWrapper {
    public OrderDBCursor(Cursor cursor) {
        super(cursor);
    }

    public Order getOrder() {
        String customerId = getString(getColumnIndex(orderTable.Cols.CUSTOMER_ID));
        String time = getString(getColumnIndex(orderTable.Cols.TIME));
        Double totalCost = getDouble(getColumnIndex(orderTable.Cols.TOTAL_COST));
        String foodList = getString(getColumnIndex(orderTable.Cols.FOOD_LIST));
        return new Order(customerId, time, totalCost, foodList);
    }
}
