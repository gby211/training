package com.example.p0571_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    String[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};

    GridView gridView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this,R.layout.item,R.id.textView, data);
        gridView = findViewById(R.id.gvMain);
        gridView.setAdapter(adapter);
        adjustGridView();
    }

    private void adjustGridView() {
        gridView.setNumColumns(GridView.AUTO_FIT);
        gridView.setColumnWidth(50);
        gridView.setVerticalSpacing(50);
        gridView.setHorizontalSpacing(50);
        gridView.setStretchMode(GridView.NO_STRETCH);;
    }
}