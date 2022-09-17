package com.example.mad_assignment_1.databases.carts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.example.mad_assignment_1.databases.carts.CartDBSchema.CartTable;
import com.example.mad_assignment_1.databases.food.FoodDBCursor;
import com.example.mad_assignment_1.databases.food.foodDBSchema;
import com.example.mad_assignment_1.databases.restaurants.RestaurantDBSchema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartDBModel
{
    private static CartDBModel instance = null;
    private SQLiteDatabase db; // The database connection

    private CartDBModel() {}

    public static CartDBModel getInstance()
    {
        if(instance == null)
        {
            instance = new CartDBModel();
        }

        return instance;
    }

    public void load(Context context)
    {
        this.db = new CartDBHelper(context.getApplicationContext()).getWritableDatabase();
    }

    public void addCart(Cart cart)
    {
        ContentValues cv = new ContentValues();
        cv.put(CartTable.Cols.ID, cart.getCartId());
        cv.put(CartTable.Cols.ITEMS, cart.getItems());
        cv.put(CartTable.Cols.TOTAL_AMOUNT, cart.getTotalAmount());
        cv.put(CartTable.Cols.CUSTOMER_EMAIL, cart.getCustomerEmail());
        db.insert(CartTable.NAME, null, cv);
    }

    public void removeCart(Cart cart)
    {
        String[] whereValue = { String.valueOf(cart.getCartId()) };
        db.delete(CartTable.NAME, CartTable.Cols.ID + " = ?", whereValue);
    }

    public void updateCart(Cart cart)
    {
        ContentValues cv = new ContentValues();
        String[] whereValue = { String.valueOf(cart.getCartId()) };
        db.update(CartTable.NAME, cv, CartTable.Cols.ID + " = ?", whereValue);
    }

    public List<Cart> getAllCarts()
    {
        List<Cart> cartList = new ArrayList<>();
        CartDBCursor cursor = new CartDBCursor(db.query(CartTable.NAME, null, null, null, null, null, null));

        try
        {
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                cartList.add(cursor.getCart());
                cursor.moveToNext();
            }
        }
        finally
        {
            cursor.close();
        }

        return cartList;
    }

    public String getNewCartId()
    {
        int largestId = 1;
        CartDBCursor cursor = new CartDBCursor(db.query(CartTable.NAME, null, null, null, null, null, null));
        try
        {
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                int currentId = Integer.parseInt(cursor.getCart().getCartId());
                if (currentId > largestId) {
                    largestId = currentId;
                }
                cursor.moveToNext();
            }
        }
        finally
        {
            cursor.close();
        }

        return String.valueOf(largestId + 1);
    }

    public Cart getCartById(String cartId)
    {
        String searchQuery =
                "SELECT * " +
                "FROM " + CartTable.NAME + " " +
                "WHERE " + CartTable.Cols.ID + " = " + "'" + cartId + "';";

        Cursor cursor = db.rawQuery(searchQuery, null);
        CartDBCursor cartDBCursor = new CartDBCursor(cursor);

        try
        {
            cartDBCursor.moveToFirst();
            while(!cartDBCursor.isAfterLast())
            {
                return cartDBCursor.getCart(); // Returns a cart with matching cartId if found
            }
        }
        finally
        {
            cartDBCursor.close();
        }

        return null;
    }

    public int getSize()
    {
        return (int) DatabaseUtils.queryNumEntries(db, CartTable.NAME);
    }
}
