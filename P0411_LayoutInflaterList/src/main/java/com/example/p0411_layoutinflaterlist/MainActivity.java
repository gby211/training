package com.example.p0411_layoutinflaterlist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] name = {"Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь"};
    String[] position = {"Программер", "Бухгалтер", "Программер",
            "Программер", "Бухгалтер", "Директор", "Программер", "Охранник"};
    int salary[] = {13000, 10000, 13000, 13000, 10000, 15000, 13000, 8000};

    int[] colors = new int[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colors[0] = Color.parseColor("#ebebeb");
        colors[1] = Color.parseColor("#cccccc");


        LinearLayout linLayout = findViewById(R.id.linLayout);

        LayoutInflater ltInflater = getLayoutInflater();

        for (int i = 0; i < 100; i++) {

            Random rnd = new Random();
            //int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

            Log.d("myLogs", "i = " + i);
            View item = ltInflater.inflate(R.layout.item, linLayout, false);
            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            tvName.setText(name[i%8]);
            TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition);
            tvPosition.setText("Должность: " + position[i%8]);
            TextView tvSalary = (TextView) item.findViewById(R.id.tvSalary);
            tvSalary.setText("Оклад: " + String.valueOf(salary[i%8]));
            item.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;

            item.setBackgroundColor(colors[i%2]);
//            color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//            tvSalary.setBackgroundColor(color);
//            color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//            tvPosition.setBackgroundColor(color);
//            color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//            tvName.setBackgroundColor(color);

            linLayout.addView(item);

        }
    }
}