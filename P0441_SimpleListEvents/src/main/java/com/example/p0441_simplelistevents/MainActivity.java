package com.example.p0441_simplelistevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    ListView lvMain;
    View header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView) findViewById(R.id.lvMain);
        header = createHeader("Текст для шапки");
        lvMain.addHeaderView(header);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names, /*android.*/R.layout./*simple_list_item_1*/my_simple_list_item);
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(LOG_TAG,"itemClick: position = " + i + ", id = " + l);
            }
        });
        lvMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(LOG_TAG,"itemClick: position = " + i + ", id = " + l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d(LOG_TAG, "itemSelect: nothing");
            }
        });
    }

    View createHeader(String text) {
        View view = getLayoutInflater().inflate(R.layout.list_header, null);
        ((TextView)view.findViewById(R.id.textViewHeaderText)).setText(text);
        return view;
    }
}