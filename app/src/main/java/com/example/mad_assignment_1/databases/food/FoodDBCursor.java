package com.example.mad_assignment_1.databases.food;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.mad_assignment_1.databases.food.foodDBSchema.foodTable;

public class FoodDBCursor extends CursorWrapper {
    public FoodDBCursor(Cursor cursor) {
        super(cursor);
    }

    public Food getFood() {
        String id = getString(getColumnIndex(foodTable.Cols.ID));
        String name = getString(getColumnIndex(foodTable.Cols.NAME));
        double price = getDouble(getColumnIndex(foodTable.Cols.PRICE));
        String description = getString(getColumnIndex(foodTable.Cols.DESCRIPTION));
        String restaurantId = getString(getColumnIndex(foodTable.Cols.RESTAURANT_ID));
        int image = getInt(getColumnIndex(foodTable.Cols.IMAGE));
        return new Food(id, name, price, description, restaurantId, image);
    }
}
