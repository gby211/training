package com.example.p0381_sqlitetransaction;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";

    DBHelper dbh;
    SQLiteDatabase db;

    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "--- onCreate Activity ---");
        dbh = new DBHelper(this);
        myActions();
    }

    void myActions() {
        try {
            db = dbh.getWritableDatabase();
            delete(db, "mytable");

            db.beginTransaction();
            insert(db, "mytable", "val1");

            Log.d(LOG_TAG, "create DBHelper");
            DBHelper dbh2 = new DBHelper(this);
            Log.d(LOG_TAG, "get db");
            SQLiteDatabase db2 = dbh2.getWritableDatabase();
            read(db2, "mytable");
            dbh2.close();

            db.setTransactionSuccessful();
            db.endTransaction();

            read(db, "mytable");
            dbh.close();

        } catch (Exception ex) {
            Log.d(LOG_TAG, ex.getClass() + " error: " + ex.getMessage());
        }

    }

    void insert(SQLiteDatabase db, String table, String value) {
        Log.d(LOG_TAG, "Insert in table " + table + " value = " + value);
        ContentValues cv = new ContentValues();
        cv.put("val", value);
        db.insert(table, null, cv);


    }

    @SuppressLint("Range")
    void read(SQLiteDatabase db, String table) {
        Log.d(LOG_TAG, "Read table " + table);
        Cursor c = db.query(table, null, null, null, null, null, null);
        if (c != null) {
            Log.d(LOG_TAG, "Records count = " + c.getCount());
            if (c.moveToFirst()) {
                do {
                    Log.d(LOG_TAG, c.getString(c.getColumnIndex("val")));
                } while (c.moveToNext());
            }
            c.close();
        }
    }

    void delete(SQLiteDatabase db, String table) {
        Log.d(LOG_TAG, "Delete all from table " + table);
        db.delete(table, null, null);
    }

    public void ggs(View view) {
        dbh.close();
    }

    public void ggs1(View view) {
        db = dbh.getWritableDatabase();
    }

    // класс для работы с БД
    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, "myDB", null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");

            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "val text"
                    + ");");

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}