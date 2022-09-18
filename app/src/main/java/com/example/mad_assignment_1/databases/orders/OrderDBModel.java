package com.example.mad_assignment_1.databases.orders;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.mad_assignment_1.databases.orders.OrderDBSchema.orderTable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

<<<<<<< Updated upstream
public class OrderDBModel
{
    private static OrderDBModel instance = null;
    private SQLiteDatabase database;
=======
public class OrderDBModel {
    private static OrderDBModel instance = null;
    SQLiteDatabase database;
>>>>>>> Stashed changes

    private OrderDBModel() {}

    public static OrderDBModel getInstance()
    {
        if(instance == null)
        {
            instance = new OrderDBModel();
        }

        return instance;
    }

<<<<<<< Updated upstream
    public void load(Context context)
    {
=======
    public void load(Context context) {
>>>>>>> Stashed changes
        this.database = new OrderDBHelper(context).getWritableDatabase();
    }

    public void addOrder(@NonNull Order order)
    {
        ContentValues cv = new ContentValues();
        cv.put(orderTable.Cols.CUSTOMER_ID, order.getCustomerId());
        cv.put(orderTable.Cols.TIME, order.getTime());
        cv.put(orderTable.Cols.DATE, order.getDate());
        cv.put(orderTable.Cols.CART_ID, order.getCartId());
        database.insert(orderTable.NAME, null, cv);
    }

    public ArrayList<Order> getAllOrders()
    {
        ArrayList<Order> orderList = new ArrayList<>();
        Cursor cursor = database.query(orderTable.NAME, null, null, null, null, null, null);
        OrderDBCursor orderDBCursor = new OrderDBCursor(cursor);

        try
        {
            orderDBCursor.moveToFirst();
            while (!orderDBCursor.isAfterLast())
            {
                orderList.add(orderDBCursor.getOrder());
                orderDBCursor.moveToNext();
            }
        }
        finally
        {
            cursor.close();
        }
        return orderList;
    }

    public int getSize() {
        return (int) DatabaseUtils.queryNumEntries(database, orderTable.NAME);
    }
}
