package com.example.mad_assignment_1.databases.restaurants;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.example.mad_assignment_1.data.RestaurantData;
import com.example.mad_assignment_1.databases.restaurants.RestaurantDBSchema.RestaurantTable;

public class RestaurantDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "restaurants.db";

    public RestaurantDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
            "CREATE TABLE " + RestaurantTable.NAME + "(" +
                    RestaurantTable.Cols.ID + " TEXT, " +
                    RestaurantTable.Cols.NAME + " TEXT, " +
                    RestaurantTable.Cols.IMAGE + " INTEGER);"
            );

        RestaurantData restaurantData = RestaurantData.getInstance();

        for (int i = 0; i < restaurantData.size(); i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(RestaurantTable.Cols.ID, restaurantData.getAtIndex(i).getId());
            contentValues.put(RestaurantTable.Cols.NAME, restaurantData.getAtIndex(i).getName());
            contentValues.put(RestaurantTable.Cols.IMAGE, restaurantData.getAtIndex(i).getImage());
            sqLiteDatabase.insert(RestaurantTable.NAME, null, contentValues);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}