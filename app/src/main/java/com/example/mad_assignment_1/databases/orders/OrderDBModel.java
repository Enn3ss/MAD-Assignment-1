package com.example.mad_assignment_1.databases.orders;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.mad_assignment_1.databases.orders.OrderDBSchema.OrderTable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class OrderDBModel
{
    private static OrderDBModel instance = null;
    private SQLiteDatabase database;

    private OrderDBModel() {}

    public static OrderDBModel getInstance()
    {
        if(instance == null)
        {
            instance = new OrderDBModel();
        }

        return instance;
    }

    public void load(Context context)
    {
        this.database = new OrderDBHelper(context).getWritableDatabase();
    }

    public void addOrder(@NonNull Order order)
    {
        ContentValues cv = new ContentValues();
        cv.put(OrderTable.Cols.CUSTOMER_EMAIL, order.getCustomerId());
        cv.put(OrderTable.Cols.TIME, order.getTime());
        cv.put(OrderTable.Cols.DATE, order.getDate());
        cv.put(OrderTable.Cols.CART_ID, order.getCartId());
        database.insert(OrderTable.NAME, null, cv);
    }

    public ArrayList<Order> getOrdersFrom(String customerEmail) {
        ArrayList<Order> orderList = new ArrayList<>();
        String searchQuery =
                "SELECT * " +
                        "FROM " + OrderTable.NAME + " " +
                        "WHERE " + OrderTable.Cols.CUSTOMER_EMAIL + " = '" + customerEmail + "';";
        Cursor cursor = database.rawQuery(searchQuery, null);
        OrderDBCursor orderDBCursor = new OrderDBCursor(cursor);

        try {
            orderDBCursor.moveToFirst();
            while (!orderDBCursor.isAfterLast()) {
                orderList.add(orderDBCursor.getOrder());
                orderDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return orderList;
    }

    public int getSize() {
        return (int) DatabaseUtils.queryNumEntries(database, OrderTable.NAME);
    }

    public int getSizeFrom(String customerEmail) {
        int count = 0;
        String searchQuery =
                "SELECT * " +
                        "FROM " + OrderTable.NAME + " " +
                        "WHERE " + OrderTable.Cols.CUSTOMER_EMAIL + " = '" + customerEmail + "';";
        Cursor cursor = database.rawQuery(searchQuery, null);
        OrderDBCursor orderDBCursor = new OrderDBCursor(cursor);

        try {
            orderDBCursor.moveToFirst();
            while (!orderDBCursor.isAfterLast()) {
                count += 1;
                orderDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return count;
    }
}
