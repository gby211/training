package com.example.p0361_sqlitequery;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.p0361_sqlitequery.MainActivity.LOG_TAG;


public class DBHelper extends SQLiteOpenHelper {

    public static final String MYTABLE_ID = "_id";
    public static final String DB_NAME = "mytable";
    public static final String MYTABLE_NAME = "name";
    public static final String MYTABLE_PEOPLE = "people";
    public static final String MYTABLE_REGION = "region";


    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, "myDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table mytable ("
                + "_id integer primary key autoincrement," + "name text,"
                + "people integer," + "region text" + ");");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
