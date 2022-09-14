package com.example.mad_assignment_1.databases.customers;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.mad_assignment_1.databases.customers.CustomerDBSchema.customerTable;

public class CustomerDBCursor extends CursorWrapper {
    public CustomerDBCursor(Cursor cursor) {
        super(cursor);
    }

    public Customer getCustomer() {
        String id = getString(getColumnIndex(customerTable.Cols.ID));
        String fullName = getString(getColumnIndex(customerTable.Cols.FULLNAME));
        String email = getString(getColumnIndex(customerTable.Cols.EMAIL));
        String password = getString(getColumnIndex(customerTable.Cols.PASSWORD));
        return new Customer(id, fullName, email, password);
    }
}