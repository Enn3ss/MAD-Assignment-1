package com.example.mad_assignment_1.databases.food;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.mad_assignment_1.databases.food.foodDBSchema.foodTable;
import com.example.mad_assignment_1.databases.restaurants.Restaurant;
import com.example.mad_assignment_1.databases.restaurants.RestaurantDBCursor;
import com.example.mad_assignment_1.databases.restaurants.RestaurantDBSchema;

import java.io.Serializable;
import java.util.ArrayList;

public class FoodDBModel {
    SQLiteDatabase database;

    public void load(Context context) {
        this.database = new FoodDBHelper(context).getWritableDatabase();
    }

    public void addFood(@NonNull Food food) {
        ContentValues cv = new ContentValues();
        cv.put(foodTable.Cols.ID, food.getId());
        cv.put(foodTable.Cols.NAME, food.getName());
        cv.put(foodTable.Cols.PRICE, food.getPrice());
        cv.put(foodTable.Cols.DESCRIPTION, food.getDescription());
        cv.put(foodTable.Cols.RESTAURANT_ID, food.getRestaurantId());
        cv.put(foodTable.Cols.IMAGE, food.getImage());
        database.insert(foodTable.NAME, null, cv);
    }

    public ArrayList<Food> getAllFood() {
        ArrayList<Food> foodList = new ArrayList<>();
        Cursor cursor = database.query(foodTable.NAME, null, null, null, null, null ,null);
        FoodDBCursor foodDBCursor = new FoodDBCursor(cursor);

        try {
            foodDBCursor.moveToFirst();
            while (!foodDBCursor.isAfterLast()) {
                foodList.add(foodDBCursor.getFood());
                foodDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return foodList;
    }

    public ArrayList<Food> getSpecials() {
        ArrayList<Food> foodList = new ArrayList<>();
        Cursor cursor = database.query(foodTable.NAME, null, null, null, null, null, "RANDOM() LIMIT 10");
        FoodDBCursor foodDBCursor = new FoodDBCursor(cursor);

        try {
            foodDBCursor.moveToFirst();
            while (!foodDBCursor.isAfterLast()) {
                foodList.add(foodDBCursor.getFood());
                foodDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return foodList;
    }

    public ArrayList<Food> getFoodFrom(String restaurantId) {
        ArrayList<Food> foodList = new ArrayList<>();
        String searchQuery =
                "SELECT * " +
                "FROM " + foodTable.NAME + " " +
                "WHERE " + foodTable.Cols.RESTAURANT_ID + " = " + restaurantId;
        Cursor cursor = database.rawQuery(searchQuery, null);
        FoodDBCursor foodDBCursor = new FoodDBCursor(cursor);

        try {
            foodDBCursor.moveToFirst();
            while (!foodDBCursor.isAfterLast()) {
                foodList.add(foodDBCursor.getFood());
                foodDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return foodList;
    }

    public Food getFoodById(String foodId) {
        FoodDBCursor cursor = new FoodDBCursor(database.query(foodTable.NAME, null, "id=?", new String[]{foodId}, null, null, null));

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                return cursor.getFood(); // Returns a food with matching foodId if found
            }
        } finally {
            cursor.close();
        }
        return null;
    }

    public int getSize() {
        return (int) DatabaseUtils.queryNumEntries(database, foodTable.NAME);
    }

    public int getSizeFrom(String restaurantId) {
        int count = 0;
        String searchQuery =
                "SELECT * " +
                "FROM " + foodTable.NAME + " " +
                "WHERE " + foodTable.Cols.RESTAURANT_ID + " = " + restaurantId;
        Cursor cursor = database.rawQuery(searchQuery, null);
        FoodDBCursor foodDBCursor = new FoodDBCursor(cursor);

        try {
            foodDBCursor.moveToFirst();
            while (!foodDBCursor.isAfterLast()) {
                count += 1;
                foodDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return count;
    }
}
