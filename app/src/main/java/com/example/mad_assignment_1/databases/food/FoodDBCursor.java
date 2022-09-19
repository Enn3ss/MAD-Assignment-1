package com.example.mad_assignment_1.databases.food;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.mad_assignment_1.databases.food.foodDBSchema.FoodTable;

public class FoodDBCursor extends CursorWrapper {
    public FoodDBCursor(Cursor cursor) {
        super(cursor);
    }

    public Food getFood() {
        String id = getString(getColumnIndex(FoodTable.Cols.ID));
        String name = getString(getColumnIndex(FoodTable.Cols.NAME));
        double price = getDouble(getColumnIndex(FoodTable.Cols.PRICE));
        String description = getString(getColumnIndex(FoodTable.Cols.DESCRIPTION));
        String restaurantId = getString(getColumnIndex(FoodTable.Cols.RESTAURANT_ID));
        int image = getInt(getColumnIndex(FoodTable.Cols.IMAGE));
        return new Food(id, name, price, description, restaurantId, image);
    }
}
