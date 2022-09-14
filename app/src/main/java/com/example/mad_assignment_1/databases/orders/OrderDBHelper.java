package com.example.mad_assignment_1.databases.orders;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.example.mad_assignment_1.databases.orders.OrderDBSchema.orderTable;

public class OrderDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "orders.db";

    public OrderDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
            "create table " + orderTable.NAME + "(" +
                    orderTable.Cols.CUSTOMER_ID + " TEXT, " +
                    orderTable.Cols.TIME + " TEXT, " +
                    orderTable.Cols.TOTAL_COST + " REAL, " +
                    orderTable.Cols.FOOD_LIST + " TEXT);"
            );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
