package com.example.mad_assignment_1.databases.customers;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.mad_assignment_1.databases.customers.CustomerDBSchema.CustomerTable;

public class CustomerDBCursor extends CursorWrapper {
    public CustomerDBCursor(Cursor cursor) {
        super(cursor);
    }

    public Customer getCustomer() {
        String email = getString(getColumnIndex(CustomerTable.Cols.EMAIL));
        String password = getString(getColumnIndex(CustomerTable.Cols.PASSWORD));
        String cartId = getString(getColumnIndex(CustomerTable.Cols.CART_ID));
        return new Customer(email, password, cartId);
    }
}