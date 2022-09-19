package com.example.mad_assignment_1.databases.restaurants;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.mad_assignment_1.databases.restaurants.RestaurantDBSchema.RestaurantTable;

public class RestaurantDBCursor extends CursorWrapper {
    public RestaurantDBCursor(Cursor cursor) {
        super(cursor);
    }

    public Restaurant getRestaurant() {
        String id = getString(getColumnIndex(RestaurantTable.Cols.ID));
        String name = getString(getColumnIndex(RestaurantTable.Cols.NAME));
        int image = getInt(getColumnIndex(RestaurantTable.Cols.IMAGE));
        return new Restaurant(id, name, image);
    }
}