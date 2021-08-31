package com.example.p0711_preferencessimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ggs(View view) {
        Intent ggs = new Intent(this,PrefActivity.class);
        startActivity(ggs);
    }

}