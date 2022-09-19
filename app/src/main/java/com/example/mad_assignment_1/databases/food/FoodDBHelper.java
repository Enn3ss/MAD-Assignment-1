package com.example.mad_assignment_1.databases.food;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.example.mad_assignment_1.data.FoodData;
import com.example.mad_assignment_1.databases.food.foodDBSchema.FoodTable;

public class FoodDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "food.db";

    public FoodDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + FoodTable.NAME + "(" +
                        FoodTable.Cols.ID + " TEXT, " +
                        FoodTable.Cols.NAME + " TEXT, " +
                        FoodTable.Cols.PRICE + " REAL, " +
                        FoodTable.Cols.DESCRIPTION + " TEXT, " +
                        FoodTable.Cols.RESTAURANT_ID + " TEXT, " +
                        FoodTable.Cols.IMAGE + " INTEGER);"
        );

        FoodData foodData = FoodData.getInstance();

        for (int i = 0; i < foodData.size(); i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(FoodTable.Cols.ID, foodData.getAtIndex(i).getId());
            contentValues.put(FoodTable.Cols.NAME, foodData.getAtIndex(i).getName());
            contentValues.put(FoodTable.Cols.PRICE, foodData.getAtIndex(i).getPrice());
            contentValues.put(FoodTable.Cols.DESCRIPTION, foodData.getAtIndex(i).getDescription());
            contentValues.put(FoodTable.Cols.RESTAURANT_ID, foodData.getAtIndex(i).getRestaurantId());
            contentValues.put(FoodTable.Cols.IMAGE, foodData.getAtIndex(i).getImage());
            sqLiteDatabase.insert(FoodTable.NAME, null, contentValues);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
