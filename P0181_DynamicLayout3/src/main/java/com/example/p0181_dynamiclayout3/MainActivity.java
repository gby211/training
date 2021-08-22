package com.example.p0181_dynamiclayout3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener , View.OnClickListener {

    SeekBar sbWeight;
    Button btn1, btn2, btn31, btn32, btn33;

    LinearLayout llMain;
    LinearLayout.LayoutParams lParams1, lParams2;

    ScrollView sklv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbWeight = (SeekBar) findViewById(R.id.sbWeight);
        sbWeight.setOnSeekBarChangeListener(this);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn31 = findViewById(R.id.btn31);
        btn32 = findViewById(R.id.btn32);
        btn33 = findViewById(R.id.btn33);

        llMain = findViewById(R.id.llSpuwn);

        sklv = findViewById(R.id.skrv);

        btn31.setOnClickListener(this::onClick);
        btn32.setOnClickListener(this::onClick);
        btn33.setOnClickListener(this::onClick);

        lParams1 = (LinearLayout.LayoutParams) btn1.getLayoutParams();
        lParams2 = (LinearLayout.LayoutParams) btn2.getLayoutParams();


        sklv.fullScroll(View.FOCUS_DOWN);

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int left = progress;
        int right = seekBar.getMax() - progress;
        lParams1.weight = left;
        lParams2.weight = right;

        btn1.setText(String.valueOf(left));
        btn2.setText(String.valueOf(right));
        btn1.requestLayout();

        sklv.fullScroll(View.FOCUS_DOWN);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void sbros(View view) {

        lParams1.weight = 1;
        lParams2.weight = 1;
        sbWeight.setProgress(sbWeight.getMax() / 2);
        btn1.setText("Button1");
        btn2.setText("Button2");
        btn1.requestLayout();
    }


    @Override
    public void onClick(View v) {
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        int btnGravity = Gravity.LEFT;
        switch (v.getId()){

            case R.id.btn31:
                btnGravity = Gravity.LEFT;
                break;
            case R.id.btn32:
                btnGravity = Gravity.CENTER_HORIZONTAL;
                break;
            case R.id.btn33:
                btnGravity = Gravity.RIGHT;
                break;
        }
        lParams.gravity = btnGravity;
        Button btnn = new Button(this);
        llMain.addView(btnn,lParams);
        sklv.fullScroll(View.FOCUS_DOWN);
    }
}