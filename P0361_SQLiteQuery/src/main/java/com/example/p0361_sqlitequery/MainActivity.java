package com.example.p0361_sqlitequery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import static com.example.p0361_sqlitequery.DBHelper.DB_NAME;
import static com.example.p0361_sqlitequery.DBHelper.MYTABLE_ID;
import static com.example.p0361_sqlitequery.DBHelper.MYTABLE_NAME;
import static com.example.p0361_sqlitequery.DBHelper.MYTABLE_PEOPLE;
import static com.example.p0361_sqlitequery.DBHelper.MYTABLE_REGION;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String LOG_TAG = "myLogs";

    String name[] = {"Китай", "США", "Бразилия", "Россия", "Япония",
            "Германия", "Египет", "Италия", "Франция", "Канада"};
    int people[] = {1400, 311, 195, 142, 128, 82, 80, 60, 66, 35};
    String region[] = {"Азия", "Америка", "Америка", "Европа", "Азия",
            "Европа", "Африка", "Европа", "Европа", "Америка"};


    Button btnAll, btnFunc, btnPeople, btnSort, btnGroup, btnHaving;
    EditText etFunc, etPeople, etRegionPeople;
    RadioGroup rgSort;

    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAll = (Button) findViewById(R.id.btnAll);
        btnAll.setOnClickListener(this);

        btnFunc = (Button) findViewById(R.id.btnFunc);
        btnFunc.setOnClickListener(this);

        btnPeople = (Button) findViewById(R.id.btnPeople);
        btnPeople.setOnClickListener(this);

        btnSort = (Button) findViewById(R.id.btnSort);
        btnSort.setOnClickListener(this);

        btnGroup = (Button) findViewById(R.id.btnGroup);
        btnGroup.setOnClickListener(this);

        btnHaving = (Button) findViewById(R.id.btnHaving);
        btnHaving.setOnClickListener(this);

        etFunc = (EditText) findViewById(R.id.etFunc);
        etPeople = (EditText) findViewById(R.id.etPeople);
        etRegionPeople = (EditText) findViewById(R.id.etRegionPeople);

        rgSort = (RadioGroup) findViewById(R.id.rgSort);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        // проверка существования записей и заполнение
        Cursor c = db.query(DB_NAME, null, null, null, null, null, null);
        if (c.getCount() == 0) {
            ContentValues cv = new ContentValues();
            // заполним таблицу
            for (int i = 0; i < 10; i++) {
                cv.put(MYTABLE_NAME, name[i]);
                cv.put(MYTABLE_PEOPLE, people[i]);
                cv.put(MYTABLE_REGION, region[i]);
                Log.d(LOG_TAG, MYTABLE_ID+" = " + db.insert(DB_NAME, null, cv));
            }
        }
        c.close();
        //dbHelper.close();

        // эмулируем нажатие кнопки btnAll
        onClick(btnAll);
    }

    @SuppressLint("Range")
    @Override
    public void onClick(View view) {
        db = dbHelper.getWritableDatabase();

        // данные с экрана
        String sFunc = etFunc.getText().toString();
        String sPeople = etPeople.getText().toString();
        String sRegionPeople = etRegionPeople.getText().toString();

        // переменные для query
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        // курсор
        Cursor c = null;

        switch (view.getId()) {
            case R.id.btnAll:
                Log.d(LOG_TAG, "--- Все записи ---");
                c = db.query(DB_NAME, null, null, null, null, null, null);
                break;
            case R.id.btnFunc:
                Log.d(LOG_TAG, "--- Функция " + sFunc + " ---");
                columns = new String[]{sFunc};
                c = db.query(DB_NAME, columns, null, null, null, null, null);
                break;
            case R.id.btnPeople:
                Log.d(LOG_TAG, "--- Население больше " + sPeople + " ---");
                c = db.query(DB_NAME, null, "MYTABLE_PEOPLE > " + sPeople, null, null, null,
                        null);
                break;
            case R.id.btnGroup:
                Log.d(LOG_TAG, "--- Население по региону ---");
                columns = new String[]{MYTABLE_REGION, "sum(people) as people"};
                c = db.query(DB_NAME, columns, null, null, MYTABLE_REGION, null,
                        null);
                break;
            case R.id.btnHaving:
                Log.d(LOG_TAG, "--- Регионы с населением больше " + sRegionPeople
                        + " ---");
                columns = new String[]{MYTABLE_REGION, "sum(people) people"};
                groupBy = MYTABLE_REGION;
                having = "sum(people) > " + sPeople;
                c = db.query(DB_NAME, columns, selection, null, groupBy, having, null);
                break;
            case R.id.btnSort:
                // сортировка по
                switch (rgSort.getCheckedRadioButtonId()) {
                    // наименование
                    case R.id.rName:
                        Log.d(LOG_TAG, "--- Сортировка по наименованию ---");
                        orderBy = "name";
                        break;
                    // население
                    case R.id.rPeople:
                        Log.d(LOG_TAG, "--- Сортировка по населению ---");
                        orderBy = "people";
                        break;
                    // регион
                    case R.id.rRegion:
                        Log.d(LOG_TAG, "--- Сортировка по региону ---");
                        orderBy = "region";
                        break;
                }
                c = db.query("mytable", null, null, null, null, null, orderBy);
                break;
        }

        if (c!= null){
            if(c.moveToFirst()){
                String str;
                do {
                    str = "";
                    for(String cn : c.getColumnNames()){
                        str += cn +" = " + c.getString(c.getColumnIndex(cn)) + "; ";
                    }
                    Log.d(LOG_TAG, str);
                }while (c.moveToNext());
            }
            c.close();
        } else
            Log.d(LOG_TAG, "Cursor is null");

    }

    @Override
    protected void onStop() {
        super.onStop();
        dbHelper.close();
    }
}