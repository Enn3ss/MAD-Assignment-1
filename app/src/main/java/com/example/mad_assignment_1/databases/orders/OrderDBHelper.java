package com.example.mad_assignment_1.databases.orders;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.example.mad_assignment_1.databases.orders.OrderDBSchema.OrderTable;

public class OrderDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "orders.db";

    public OrderDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
            "create table " + OrderTable.NAME + "(" +
                    OrderTable.Cols.CUSTOMER_EMAIL + " TEXT, " +
                    OrderTable.Cols.TIME + " TEXT, " +
                    OrderTable.Cols.DATE + " TEXT, " +
                    OrderTable.Cols.CART_ID + " TEXT);"
            );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
