package com.example.mad_assignment_1.databases.carts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.mad_assignment_1.databases.carts.CartDBSchema.CartTable;

public class CartDBHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "carts.db";

    public CartDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + CartTable.NAME + "(" +
                   CartTable.Cols.ID + " INTEGER, " +
                   CartTable.Cols.ITEMS + " TEXT, " +
                   CartTable.Cols.TOTAL_AMOUNT + "REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int v1, int v2)
    {

    }
}
