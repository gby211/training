package com.example.p0341_simplesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static com.example.p0341_simplesqlite.DBHelper.DB_NAME;
import static com.example.p0341_simplesqlite.DBHelper.MYTABLE_EMAIL;
import static com.example.p0341_simplesqlite.DBHelper.MYTABLE_ID;
import static com.example.p0341_simplesqlite.DBHelper.MYTABLE_NAME;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String LOG_TAG = "myLogs";

    Button btnAdd, btnRead, btnClear, btnUpd, btnDel;
    EditText etName, etEmail;
    Spinner etID;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnUpd = (Button) findViewById(R.id.btnUpd);
        btnUpd.setOnClickListener(this);

        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);

        etID = findViewById(R.id.etID);
        dbHelper = new DBHelper(this);


        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.query(DB_NAME, null, null, null, null, null, null);
        int numRows = (int) DatabaseUtils.queryNumEntries(db, DB_NAME);
        String[] arr1 = new String[numRows];
        if (c.moveToFirst()) {
            int tmp = 0;
            int idColIndex = c.getColumnIndex(MYTABLE_ID);
            do {
                arr1[tmp] = String.valueOf(c.getInt(idColIndex));
                tmp++;
            } while (c.moveToNext());
        } else
            Log.d(LOG_TAG, "0 rows");
        c.close();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        etID.setAdapter(adapter);
        etID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                etID.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }

    @Override
    public void onClick(View view) {

        // создаем объект для данных
        ContentValues cv = new ContentValues();

        // получаем данные из полей ввода
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String id = etID.getSelectedItem().toString();

        // подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch (view.getId()) {
            case R.id.btnAdd:
                Log.d(LOG_TAG, "--- Insert in mytable: ---");
                // подготовим данные для вставки в виде пар: наименование столбца - значение

                cv.put(MYTABLE_NAME, name);
                cv.put(MYTABLE_EMAIL, email);
                // вставляем запись и получаем ее ID

                long rowID = db.insert(DB_NAME, null, cv);
                Log.d(LOG_TAG, "row inserted, ID = " + rowID);
                break;
            case R.id.btnRead:
                Log.d(LOG_TAG, "--- Rows in mytable: ---");
                // делаем запрос всех данных из таблицы mytable, получаем Cursor
                Cursor c = db.query(DB_NAME, null, null, null, null, null, null);

                // ставим позицию курсора на первую строку выборки
                // если в выборке нет строк, вернется false
                if (c.moveToFirst()) {
                    int idColIndex = c.getColumnIndex(MYTABLE_ID);
                    int nameColIndex = c.getColumnIndex(MYTABLE_NAME);
                    int emailColIndex = c.getColumnIndex(MYTABLE_EMAIL);
                    do {
                        // получаем значения по номерам столбцов и пишем все в лог
                        Log.d(LOG_TAG,
                                "ID = " + c.getInt(idColIndex) +
                                        ", name = " + c.getString(nameColIndex) +
                                        ", email = " + c.getString(emailColIndex));
                        // переход на следующую строку
                        // а если следующей нет (текущая - последняя), то false - выходим из цикла
                    } while (c.moveToNext());
                } else
                    Log.d(LOG_TAG, "0 rows");
                c.close();
                break;
            case R.id.btnClear:
                Log.d(LOG_TAG, "--- Clear mytable: ---");
                // удаляем все записи
                int clearCount = db.delete(DB_NAME, null, null);
                Log.d(LOG_TAG, "deleted rows count = " + clearCount);
                break;
            case R.id.btnUpd:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                Log.d(LOG_TAG, "--- Update mytable: ---");
                // подготовим значения для обновления

                cv.put(MYTABLE_NAME, name);
                cv.put(MYTABLE_EMAIL, email);
                //обновляем по id
                try {
                    int updCount = db.update(DB_NAME, cv, "_id = ?", new String[]{id});
                    Log.d(LOG_TAG, "updated rows count = " + updCount);
                    if (updCount == 0){
                        cv.put(MYTABLE_ID,id);
                        long updCount1 =  db.insert(DB_NAME,null,cv);
                        Log.d(LOG_TAG, "new rows count = " + String.valueOf(updCount1));
                    }

                }catch (SQLiteException e){

                }

                break;
            case R.id.btnDel:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                Log.d(LOG_TAG, "--- Delete from mytable: ---");
                // удаляем по id
                int delCount = db.delete(DB_NAME,"_id = ?", new String[]{id});
                Log.d(LOG_TAG, "deleted rows count = " + delCount);
                break;


        }
        //adapter.notifyDataSetChanged();
        // закрываем подключение к БД
//        dbHelper.close();

    }

    @Override
    protected void onStop() {
        super.onStop();
        dbHelper.close();
    }
}