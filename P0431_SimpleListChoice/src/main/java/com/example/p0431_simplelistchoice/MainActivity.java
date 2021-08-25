package com.example.p0431_simplelistchoice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String LOG_TAG = "myLogs";

    ListView lvMain;
    String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = findViewById(R.id.lvMain);
        lvMain.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_list_item_single_choice);
        lvMain.setAdapter(adapter);

        Button btnChecked = findViewById(R.id.button);
        btnChecked.setOnClickListener(this);
        names = getResources().getStringArray(R.array.names);
    }

    @Override
    public void onClick(View view) {
        Log.d(LOG_TAG, "checked: " + names[lvMain.getCheckedItemPosition()]);
    }
}