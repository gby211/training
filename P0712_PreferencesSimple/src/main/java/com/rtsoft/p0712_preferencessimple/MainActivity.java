package com.rtsoft.p0712_preferencessimple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    boolean en2, en1;
    CheckBox checkBox1, checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
    }

    public void ggs(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        en1 = pref.getBoolean("wifi", false);
        en2 = pref.getBoolean("hints", true);
        if (en1) checkBox1.setChecked(true);
        else checkBox1.setChecked(false);
        if (en2) checkBox2.setChecked(true);
        else checkBox2.setChecked(false);

    }
}