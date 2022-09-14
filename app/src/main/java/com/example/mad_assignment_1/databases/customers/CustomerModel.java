package com.example.mad_assignment_1.databases.customers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.mad_assignment_1.databases.customers.CustomerDBSchema.customerTable;

import java.util.ArrayList;

public class CustomerModel {
    SQLiteDatabase database;

    public void load(Context context) {
        this.database = new CustomerDBHelper(context).getWritableDatabase();
    }

    public void addCustomer(@NonNull Customer customer) {
        ContentValues cv = new ContentValues();
        cv.put(customerTable.Cols.ID, customer.getId());
        cv.put(customerTable.Cols.FULLNAME, customer.getFullName());
        cv.put(customerTable.Cols.EMAIL, customer.getEmail());
        cv.put(customerTable.Cols.PASSWORD, customer.getPassword());
        database.insert(customerTable.NAME, null, cv);
    }

    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customerList = new ArrayList<>();
        Cursor cursor = database.query(customerTable.NAME, null, null, null, null, null, null);
        CustomerDBCursor customerDBCursor = new CustomerDBCursor(cursor);

        try {
            customerDBCursor.moveToFirst();
            while (!customerDBCursor.isAfterLast()) {
                customerList.add(customerDBCursor.getCustomer());
                customerDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return customerList;
    }
}