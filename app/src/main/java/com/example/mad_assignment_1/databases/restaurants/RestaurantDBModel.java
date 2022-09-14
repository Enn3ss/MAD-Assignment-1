package com.example.mad_assignment_1.databases.restaurants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.mad_assignment_1.databases.restaurants.RestaurantDBSchema.restaurantTable;

import java.util.ArrayList;

public class RestaurantDBModel {
    SQLiteDatabase database;

    public void load(Context context) {
        this.database = new RestaurantDBHelper(context).getWritableDatabase();
    }

    public void addRestaurant(@NonNull Restaurant restaurant) {
        ContentValues cv = new ContentValues();
        cv.put(restaurantTable.Cols.ID, restaurant.getId());
        cv.put(restaurantTable.Cols.NAME, restaurant.getName());
        cv.put(restaurantTable.Cols.IMAGE, restaurant.getImage());
        database.insert(restaurantTable.NAME, null, cv);
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

    public void clearTable() {
        database.execSQL("delete from " + restaurantTable.NAME);
    }

    public int getSize() {
        return (int) DatabaseUtils.queryNumEntries(database, restaurantTable.NAME);
    }
}