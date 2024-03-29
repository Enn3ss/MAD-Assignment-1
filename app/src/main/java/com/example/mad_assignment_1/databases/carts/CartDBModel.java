package com.example.mad_assignment_1.databases.carts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.mad_assignment_1.databases.carts.CartDBSchema.CartTable;
import com.example.mad_assignment_1.databases.food.Food;

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

    public void addItemToCart(Cart cart, Food food) {
        String newItems;
        if (cart.isCartEmpty()) {
            newItems = food.getId();
        }
        else {
            newItems = cart.getItems() + "," + food.getId();
        }

        double newTotalAmount = cart.getTotalAmount() + food.getPrice();

        ContentValues cv = new ContentValues();
        cv.put(CartTable.Cols.ID, cart.getCartId());
        cv.put(CartTable.Cols.ITEMS, newItems);
        cv.put(CartTable.Cols.TOTAL_AMOUNT, newTotalAmount);
        cv.put(CartTable.Cols.CUSTOMER_EMAIL, cart.getCustomerEmail());

        String[] whereValue = { String.valueOf(cart.getCartId()) };
        db.update(CartTable.NAME, cv, CartTable.Cols.ID + " = ?", whereValue);
    }

    public void removeItemFromCart(Cart cart, Food food) {
        String newItems;
        String cartItems = cart.getItems();
        String foodId = food.getId();

        if (!cart.isCartEmpty()) {
            // if there is more than 1 id in items
            if (cartItems.contains(",")) {
                // get the first id
                String firstItem = cartItems.substring(cartItems.indexOf(cartItems.charAt(0)), cartItems.indexOf(","));
                //if the first id is equal to foodId
                if (firstItem.equals(foodId)) {
                    // remove the first id plus the ","
                    newItems = cartItems.replaceFirst(firstItem + ",", "");
                }
                else {
                    // remove the foodId plus the "," before it
                    newItems = cartItems.replaceFirst("," + foodId, "");
                }
            }
            else {
                if (cartItems.equals(foodId)) {
                    newItems = "";
                }
                else {
                    newItems = cartItems;
                }
            }
            double newTotalAmount = cart.getTotalAmount() - food.getPrice();

            ContentValues cv = new ContentValues();
            cv.put(CartTable.Cols.ID, cart.getCartId());
            cv.put(CartTable.Cols.ITEMS, newItems);
            cv.put(CartTable.Cols.TOTAL_AMOUNT, newTotalAmount);
            cv.put(CartTable.Cols.CUSTOMER_EMAIL, cart.getCustomerEmail());

            String[] whereValue = { String.valueOf(cart.getCartId()) };
            db.update(CartTable.NAME, cv, CartTable.Cols.ID + " = ?", whereValue);
        }
    }

    public String getNewCartId()
    {
        int largestId = 0;
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
}
