package com.example.mad_assignment_1.databases.food;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mad_assignment_1.databases.food.foodDBSchema.foodTable;

import java.util.ArrayList;

public class FoodDBModel {
    private static FoodDBModel instance = null;
    SQLiteDatabase database;

    private FoodDBModel() {}

    public static FoodDBModel getInstance()
    {
        if(instance == null)
        {
            instance = new FoodDBModel();
        }

        return instance;
    }

    public void load(Context context) {
        this.database = new FoodDBHelper(context).getWritableDatabase();
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
        Food food = null;
        String searchQuery =
                "SELECT * " +
                "FROM " + foodTable.NAME + " " +
                "WHERE " + foodTable.Cols.ID + " = " + foodId;
        Cursor cursor = database.rawQuery(searchQuery, null);
        FoodDBCursor foodDBCursor = new FoodDBCursor(cursor);

        try {
            foodDBCursor.moveToFirst();
            while (!foodDBCursor.isAfterLast()) {
                food = foodDBCursor.getFood();
                foodDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return food;
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
