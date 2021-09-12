package com.example.p1801_constraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;

import android.graphics.Color;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    float tmp = (float) 0.1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_test);

        Group group1 = findViewById(R.id.group1);
        Group group2 = findViewById(R.id.group2);
        ConstraintLayout constraintLayout = findViewById(R.id.conteiner);
        Button btn = findViewById(R.id.button4);
        Button btn2 = findViewById(R.id.button5);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                group1.setBackgroundColor(Color.GREEN);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(constraintLayout);
                changeConstraints(constraintSet);

                TransitionManager.beginDelayedTransition(constraintLayout);

                constraintSet.applyTo(constraintLayout);

            }
        });


    }

    private void changeConstraints(ConstraintSet set) {
        set.clear(R.id.textView15,ConstraintSet.TOP);

        set.connect(R.id.textView15,ConstraintSet.TOP,R.id.button5,ConstraintSet.BOTTOM,R.dimen.some_margin);
    }
}