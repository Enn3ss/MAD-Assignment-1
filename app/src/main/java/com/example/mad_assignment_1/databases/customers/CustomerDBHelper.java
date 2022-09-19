package com.example.mad_assignment_1.databases.customers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.example.mad_assignment_1.databases.customers.CustomerDBSchema.CustomerTable;

public class CustomerDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "customers.db";

    public CustomerDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
            "CREATE TABLE " + CustomerTable.NAME + "(" +
                    CustomerTable.Cols.EMAIL + " TEXT, " +
                    CustomerTable.Cols.PASSWORD + " TEXT, " +
                    CustomerTable.Cols.CART_ID + " TEXT);"
            );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
