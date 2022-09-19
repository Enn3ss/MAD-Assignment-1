package com.example.mad_assignment_1.databases.orders;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.mad_assignment_1.databases.orders.OrderDBSchema.OrderTable;

public class OrderDBCursor extends CursorWrapper {
    public OrderDBCursor(Cursor cursor) {
        super(cursor);
    }

    public Order getOrder() {
        String customerId = getString(getColumnIndex(OrderTable.Cols.CUSTOMER_EMAIL));
        String time = getString(getColumnIndex(OrderTable.Cols.TIME));
        String date = getString(getColumnIndex(OrderTable.Cols.DATE));
        String cartId = getString(getColumnIndex(OrderTable.Cols.CART_ID));
        return new Order(customerId, time, date, cartId);
    }
}
