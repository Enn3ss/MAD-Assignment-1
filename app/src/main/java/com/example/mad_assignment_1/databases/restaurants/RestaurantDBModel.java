package com.example.mad_assignment_1.databases.restaurants;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.mad_assignment_1.databases.restaurants.RestaurantDBSchema.restaurantTable;

import java.util.ArrayList;

public class RestaurantDBModel {
    private static RestaurantDBModel instance = null;
    private SQLiteDatabase database;

    private RestaurantDBModel() {}

    public static RestaurantDBModel getInstance()
    {
        if(instance == null)
        {
            instance = new RestaurantDBModel();
        }

        return instance;
    }

    public void load(Context context) {
        this.database = new RestaurantDBHelper(context).getWritableDatabase();
    }

    public ArrayList<Restaurant> getAllRestaurants() {
        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        Cursor cursor = database.query(restaurantTable.NAME, null, null, null, null, null ,null);
        RestaurantDBCursor restaurantDBCursor = new RestaurantDBCursor(cursor);

        try {
            restaurantDBCursor.moveToFirst();
            while (!restaurantDBCursor.isAfterLast()) {
                restaurantList.add(restaurantDBCursor.getRestaurant());
                restaurantDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return restaurantList;
    }

    public int getSize() {
        return (int) DatabaseUtils.queryNumEntries(database, restaurantTable.NAME);
    }
}