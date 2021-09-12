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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int tmp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_test);

        Group group1 = findViewById(R.id.group1);
        Group group2 = findViewById(R.id.group2);
        ConstraintLayout constraintLayout = findViewById(R.id.conteiner);
        Button btn = findViewById(R.id.button4);
        Button btn2 = findViewById(R.id.button5);
        Button btn3 = findViewById(R.id.button6);
        TextView textView = findViewById(R.id.textView15);

        textView.setClickable(true);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "asdasd", Toast.LENGTH_SHORT).show();
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                group1.setAlpha(1);
                group2.setAlpha(1);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(constraintLayout);
                if (tmp == 0) {
                    constraintSet.setMargin(R.id.button6, ConstraintSet.TOP, 33);
                    tmp += 1;
                }else {
                    constraintSet.setMargin(R.id.button6, ConstraintSet.TOP, 0);
                    tmp -=1;
                }
                constraintSet.applyTo(constraintLayout);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                group1.setAlpha(0.5F);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(constraintLayout);

                constraintSet.connect(R.id.textView15,ConstraintSet.TOP,R.id.textView14,ConstraintSet.BOTTOM,126);
                constraintSet.applyTo(constraintLayout);

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                group1.setAlpha(0.5F);
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

        set.connect(R.id.textView15,ConstraintSet.TOP,R.id.button5,ConstraintSet.BOTTOM,16);
    }

    public void action1(View view) {
        ConstraintSet constraintSet = new ConstraintSet();
        ConstraintLayout constraintLayout = findViewById(R.id.conteiner);
        constraintSet.clone(constraintLayout);
        TextView txt = findViewById(R.id.textView16);
        txt.setBackgroundColor(Color.YELLOW);

        //constraintSet.clear(R.id.textView16,ConstraintSet.TOP);
        //constraintSet.connect(R.id.textView16,ConstraintSet.BOTTOM,R.id.button4,ConstraintSet.TOP,5);
        constraintSet.setMargin(R.id.textView16, ConstraintSet.START, 0);
        constraintSet.connect(R.id.textView16, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0);
        //constraintSet.connect(R.id.textView16, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0);
        constraintSet.constrainWidth(R.id.textView16, ConstraintSet.MATCH_CONSTRAINT);

        TransitionManager.beginDelayedTransition(constraintLayout);
        constraintSet.applyTo(constraintLayout);
    }

    public void action2(View view) {
        ConstraintSet constraintSet = new ConstraintSet();
        ConstraintLayout constraintLayout = findViewById(R.id.conteiner);
        constraintSet.clone(constraintLayout);

        constraintSet.create(R.id.guideline,ConstraintSet.VERTICAL_GUIDELINE);
        constraintSet.setGuidelinePercent(R.id.guideline,0.6f);

        constraintSet.connect(R.id.textView17, ConstraintSet.LEFT, R.id.guideline, ConstraintSet.RIGHT, 0);
        constraintSet.connect(R.id.textView18, ConstraintSet.LEFT, R.id.guideline, ConstraintSet.RIGHT, 0);
        constraintSet.connect(R.id.textView19, ConstraintSet.LEFT, R.id.guideline, ConstraintSet.RIGHT, 0);

        TransitionManager.beginDelayedTransition(constraintLayout);
        constraintSet.applyTo(constraintLayout);
    }
}