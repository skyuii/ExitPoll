package com.example.exitpoll.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String TABLE_NAME = "result";
    public static final String COL_ID = "_id";
    public static final String COL_IMAGE = "image";
    public static final String COL_RESULT = "number";
    public static final String COL_TITLE = "text";

    private static final String SQL_CREATE_TABLE_NUMBER
            = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_IMAGE + " TEXT"
            + COL_RESULT + "NUMBER"
            + COL_TITLE + "TEXT"
            + ")";

    private static final String DATABASE_NAME = "poll.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, "poll.db" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_NUMBER);

        ContentValues cv = new ContentValues();
        cv.put(COL_IMAGE, "one.png");
        cv.put(COL_RESULT, "0");
        cv.put(COL_TITLE, "คะแนน");
        db.insert(TABLE_NAME, null, cv);

        cv.put(COL_IMAGE, "two.png");
        cv.put(COL_RESULT, "0");
        cv.put(COL_TITLE, "คะแนน");
        db.insert(TABLE_NAME, null, cv);

        cv.put(COL_IMAGE, "three.png");
        cv.put(COL_RESULT, "0");
        cv.put(COL_TITLE, "คะแนน");
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {

    }
}
