package com.example.mad_assignment_1.databases.customers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.mad_assignment_1.databases.carts.Cart;
import com.example.mad_assignment_1.databases.carts.CartDBSchema;
import com.example.mad_assignment_1.databases.customers.CustomerDBSchema.CustomerTable;

public class CustomerDBModel
{
    private static CustomerDBModel instance = null;
    private SQLiteDatabase database;

    private CustomerDBModel() {}

    public static CustomerDBModel getInstance()
    {
        if(instance == null)
        {
            instance = new CustomerDBModel();
        }

        return instance;
    }

    public void load(Context context)
    {
        this.database = new CustomerDBHelper(context).getWritableDatabase();
    }

    public void addCustomer(@NonNull Customer customer)
    {
        ContentValues cv = new ContentValues();
        cv.put(CustomerTable.Cols.EMAIL, customer.getEmail());
        cv.put(CustomerTable.Cols.PASSWORD, customer.getPassword());
        cv.put(CustomerTable.Cols.CART_ID, customer.getCartId());
        database.insert(CustomerTable.NAME, null, cv);
    }

    public boolean doesCustomerExist(String email)
    {
        String searchQuery =
                "SELECT * " +
                "FROM " + CustomerTable.NAME + " " +
                "WHERE " + CustomerTable.Cols.EMAIL + " = " + "'" + email + "';";

        Cursor cursor = database.rawQuery(searchQuery, null);
        CustomerDBCursor customerDBCursor = new CustomerDBCursor(cursor);

        try
        {
            customerDBCursor.moveToFirst();
            while(!customerDBCursor.isAfterLast())
            {
                return true;
            }
        }
        finally
        {
            customerDBCursor.close();
        }

        return false;
    }

    public boolean doesCustomerExist(String email, String password)
    {
        String searchQuery =
                "SELECT * " +
                 "FROM " + CustomerTable.NAME + " " +
                 "WHERE " + CustomerTable.Cols.EMAIL + " = '" + email + "' " +
                 "AND " + CustomerTable.Cols.PASSWORD + " = '" + password + "';";

        Cursor cursor = database.rawQuery(searchQuery, null);
        CustomerDBCursor customerDBCursor = new CustomerDBCursor(cursor);

        try
        {
            customerDBCursor.moveToFirst();
            while(!customerDBCursor.isAfterLast())
            {
                return true;
            }
        }
        finally
        {
            customerDBCursor.close();
        }

        return false;
    }

    public Customer getCustomer(String email)
    {
        String searchQuery =
                "SELECT * " +
                "FROM " + CustomerTable.NAME + " " +
                "WHERE " + CustomerTable.Cols.EMAIL + " = '" + email + "';";

        Cursor cursor = database.rawQuery(searchQuery, null);
        CustomerDBCursor customerDBCursor = new CustomerDBCursor(cursor);

        try
        {
            customerDBCursor.moveToFirst();
            while(!customerDBCursor.isAfterLast())
            {
                return customerDBCursor.getCustomer();
            }
        }
        finally
        {
            customerDBCursor.close();
        }

        return null;
    }

    public void setCustomerCartId(Customer customer, Cart cart) {
        ContentValues cv = new ContentValues();
        cv.put(CustomerTable.Cols.EMAIL, customer.getEmail());
        cv.put(CustomerTable.Cols.PASSWORD, customer.getPassword());
        cv.put(CustomerTable.Cols.CART_ID, cart.getCartId());

        String[] whereValue = { String.valueOf(customer.getEmail()) };
        database.update(CartDBSchema.CartTable.NAME, cv, CustomerTable.Cols.EMAIL + " = ?", whereValue);
    }
}