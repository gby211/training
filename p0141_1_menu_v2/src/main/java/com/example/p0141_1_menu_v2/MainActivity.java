package com.example.p0141_1_menu_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static final int IDM_HELP = 101;
    public static final int IDM_NEW = 201;
    public static final int IDM_OPEN = 202;
    public static final int IDM_SAVE = 203;
    public static final int IDM_CUT = 301;
    public static final int IDM_COPY = 302;
    public static final int IDM_PASTE = 303;
    public static final int IDM_COLOR_GROUP = 400;
    public static final int IDM_COLOR_RED = 401;
    public static final int IDM_COLOR_GREEN = 402;
    public static final int IDM_COLOR_BLUE = 403;
    public static final int IDM_FORMAT_BOLD = 404;

    public TextView textView ;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        textView = findViewById(R.id.textv);
        SubMenu subMenuFile = menu.addSubMenu("Файл");
        subMenuFile.add(Menu.NONE, IDM_NEW, Menu.NONE, "Новый");
        subMenuFile.add(Menu.NONE, IDM_OPEN, Menu.NONE, "Открыть");
        subMenuFile.add(Menu.NONE, IDM_SAVE, Menu.NONE, "Сохранить");
        SubMenu subMenuEdit = menu.addSubMenu("Правка");
        subMenuEdit.add(Menu.NONE, IDM_CUT, Menu.NONE, "Вырезать");
        subMenuEdit.add(Menu.NONE, IDM_COPY, Menu.NONE, "Копировать");
        subMenuEdit.add(Menu.NONE, IDM_PASTE, Menu.NONE, "Вставить");
        menu.add(Menu.NONE, IDM_HELP, Menu.NONE, "Справка");
        MenuItem item = menu.add(0, IDM_FORMAT_BOLD, 0, "Bold");
        SubMenu subMenuColor = menu.addSubMenu("Цвет");
        subMenuColor.add(IDM_COLOR_GROUP, IDM_COLOR_RED, Menu.NONE, "Красный");
        subMenuColor.add(IDM_COLOR_GROUP, IDM_COLOR_GREEN, Menu.NONE, "Зеленый");
        subMenuColor.add(IDM_COLOR_GROUP, IDM_COLOR_BLUE, Menu.NONE, "Синий");
        subMenuColor.setGroupCheckable(IDM_COLOR_GROUP, true, false);
        item.setCheckable(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence message;

        switch (item.getItemId()) {

            case IDM_COLOR_RED:
                // инвертируем состояние флажка
                item.setChecked(!item.isChecked());
                message = "Красный цвет";
                break;
            case IDM_FORMAT_BOLD:
                item.setChecked(!item.isChecked());
                if (item.isChecked()){
                    textView.setTypeface(null, Typeface.BOLD);
                    textView.setTextSize(30);
                }
                else{
                    textView.setTypeface(null, Typeface.NORMAL);
                    textView.setTextSize(14);
                }
                break;


            default:
                return false;
        }
        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(R.id.group1, false);
        return super.onPrepareOptionsMenu(menu);
    }
}