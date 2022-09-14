package com.example.mad_assignment_1.databases.food;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.example.mad_assignment_1.data.FoodData;
import com.example.mad_assignment_1.databases.food.foodDBSchema.foodTable;

public class FoodDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "food.db";

    public FoodDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + foodTable.NAME + "(" +
                        foodTable.Cols.ID + " TEXT, " +
                        foodTable.Cols.NAME + " TEXT, " +
                        foodTable.Cols.PRICE + " REAL, " +
                        foodTable.Cols.DESCRIPTION + " TEXT, " +
                        foodTable.Cols.RESTAURANT_ID + " TEXT, " +
                        foodTable.Cols.IMAGE + " INTEGER);"
        );

        FoodData foodData = FoodData.getInstance();

        for (int i = 0; i < foodData.size(); i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(foodTable.Cols.ID, foodData.getAtIndex(i).getId());
            contentValues.put(foodTable.Cols.NAME, foodData.getAtIndex(i).getName());
            contentValues.put(foodTable.Cols.PRICE, foodData.getAtIndex(i).getPrice());
            contentValues.put(foodTable.Cols.DESCRIPTION, foodData.getAtIndex(i).getDescription());
            contentValues.put(foodTable.Cols.RESTAURANT_ID, foodData.getAtIndex(i).getRestaurantId());
            contentValues.put(foodTable.Cols.IMAGE, foodData.getAtIndex(i).getImage());
            sqLiteDatabase.insert(foodTable.NAME, null, contentValues);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
