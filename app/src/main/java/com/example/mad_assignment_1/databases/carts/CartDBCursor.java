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
        String cartId = getString(getColumnIndex(CartTable.Cols.ID));
        String items = getString(getColumnIndex(CartTable.Cols.ITEMS));
        double totalAmount = getDouble(getColumnIndex(CartTable.Cols.TOTAL_AMOUNT));
        String customerId = getString((getColumnIndex(CartTable.Cols.CUSTOMER_EMAIL)));

        return new Cart(cartId, items, totalAmount, customerId);
    }
}
