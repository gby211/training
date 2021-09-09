package com.example.p1801_constraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Guideline;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    float tmp = (float) 0.1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Guideline guideline = findViewById(R.id.guideline2);
                guideline.setGuidelinePercent(tmp);
                tmp+=0.1;
                if (tmp >0.9)tmp= (float) 0.1;
            }
        });
    }
}