package com.example.p0001firstproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btn2,btn1;
    TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.textViewMain);
        myTextView.setText(R.string.main_text_main_menu);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);


//        View.OnClickListener btnListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (v.getId()){
//                    case (R.id.button1):
//                        myTextView.setText(R.string.text_after_btn1_pressed);
//                        break;
//                    case (R.id.button2):
//                        myTextView.setText(R.string.text_after_pressed_btn2);
//                        break;
//                }
//            }
//        };

        btn2.setOnClickListener(this::ggs);
        btn1.setOnClickListener(this);
    }

    public void ggs(View view) {
        Toast.makeText(this, "ggs", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.button1):
                myTextView.setText(R.string.text_after_btn1_pressed);
                break;
            case (R.id.button2):
                myTextView.setText(R.string.text_after_pressed_btn2);
                break;
        }
    }
}