package com.example.mad_assignment_1.databases.carts;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.mad_assignment_1.databases.carts.CartDBSchema.CartTable;

public class CartDBCursor extends CursorWrapper
{
    public CartDBCursor(Cursor cursor)
    {
        super(cursor);
    }

    public Cart getCart()
    {
        int cartId = getInt(getColumnIndex(CartTable.Cols.ID));
        String items = getString(getColumnIndex(CartTable.Cols.ITEMS));
        double totalAmount = getDouble(getColumnIndex(CartTable.Cols.TOTAL_AMOUNT));

        return new Cart(cartId, items, totalAmount);
    }
}
