package com.example.p0501_simpleadaptercustom2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_PB = "pb";
    final String ATTRIBUTE_NAME_LL = "ll";

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] load = {41, 48, 22, 35, 30, 67, 51, 88};
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String,Object>>(load.length);
        Map<String, Object> m;

        for (int i = 0; i < load.length; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, "Day " + (i+1) + ". Load: " + load[i] + "%");
            m.put(ATTRIBUTE_NAME_PB, load[i]);
            m.put(ATTRIBUTE_NAME_LL, load[i]);
            data.add(m);
        }

        // массив имен атрибутов, из которых будут читаться данные
        String[] from = { ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_PB,
                ATTRIBUTE_NAME_LL };
        // массив ID View-компонентов, в которые будут вставлять данные
        int[] to = { R.id.textView, R.id.pbLoad, R.id.llLoad };

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,data,R.layout.item,from,to);
        simpleAdapter.setViewBinder(new MyViewBinder());

        lvSimple =findViewById(R.id.lvSimple);
        lvSimple.setAdapter(simpleAdapter);
    }


}