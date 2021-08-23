package com.example.p0341_simplesqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static com.example.p0341_simplesqlite.MainActivity.LOG_TAG;

public class DBHelper extends SQLiteOpenHelper {

    public static final String MYTABLE_ID = "_id";
    public static final String DB_NAME = "mytable";
    public static final String MYTABLE_NAME = "name";
    public static final String MYTABLE_EMAIL = "email";


    public DBHelper(Context context) {
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(LOG_TAG, "--- onCreate database ---");
        sqLiteDatabase.execSQL("create table " + DB_NAME + " ("
                + MYTABLE_ID + " integer primary key autoincrement,"
                + MYTABLE_NAME + " text,"
                + MYTABLE_EMAIL + " text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
