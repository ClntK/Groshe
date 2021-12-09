package com.example.groshe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.groshe.GrosheContract.*;

public class GrosheDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "grocheList.db";
    public static final int DATABASE_VERSION = 1;

    public GrosheDBHelper(Context context) {
        super(context, DATABASE_NAME,
                null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_GROSHELIST_TABLE = "CREATE TABLE " +
                GrosheEntry.TABLE_NAME + " (" +
                GrosheEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                GrosheEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                GrosheEntry.COLUMN_AMOUNT + " INTEGER NOT NULL, " +
                GrosheEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        db.execSQL(SQL_CREATE_GROSHELIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + GrosheEntry.TABLE_NAME);
        onCreate(db);
    }
}
