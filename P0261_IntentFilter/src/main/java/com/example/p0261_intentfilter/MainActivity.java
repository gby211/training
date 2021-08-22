package com.example.p0261_intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTime = findViewById(R.id.btnTime);
        Button btnDate = findViewById(R.id.btnDate);

        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        try {

            switch (v.getId()) {
                case R.id.btnTime:
                    intent = new Intent("com.example.intent.action.showtime");
                    startActivity(intent);
                    break;
                case R.id.btnDate:
                    intent = new Intent("com.example.intent.action.showdate");
                    startActivity(intent);
                    break;
            }
        }catch (Exception e){

        }
    }
}