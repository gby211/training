package com.example.p0191_simplecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button btnPlus, btnMinus, btnUmno, btnDel;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        btnPlus = findViewById(R.id.button1);
        btnMinus = findViewById(R.id.button2);
        btnUmno = findViewById(R.id.button3);
        btnDel = findViewById(R.id.button4);

        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }


    public void poschitat(View view) {

        String oper = "";
        Float ansv;
        if (TextUtils.isEmpty(editText1.getText().toString()) || TextUtils.isEmpty(editText2.getText().toString())) {
            Toast.makeText(this, "Введите данные", Toast.LENGTH_SHORT).show();
            return;
        }
        Float num1 = Float.parseFloat(editText1.getText().toString());
        Float num2 = Float.parseFloat(editText2.getText().toString());
        Animation anim = null;
        switch (view.getId()) {
            case R.id.button1:
                oper = "+";
                ansv = num1 + num2;
                anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
                btnPlus.startAnimation(anim);
                btnPlus.setVisibility(View.INVISIBLE);
                break;
            case R.id.button2:
                oper = "-";
                ansv = num1 - num2;
                break;
            case R.id.button3:
                oper = "*";
                ansv = num1 * num2;
                break;
            case R.id.button4:
                oper = "/";
                ansv = num1 / num2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

        textView.setText(num1 + oper + num2 + "=" + ansv);
    }

    public void clr(View view) {
        textView.setText("");
        editText1.setText("");
        editText2.setText("");
    }

    public void menu(MenuItem item) {
        float txtSize = textView.getTextSize();
        Log.d("ggs",String.valueOf(txtSize)+"получено");
        switch (item.getItemId()) {
            case R.id.menu_men:
                Log.d("ggs",String.valueOf(txtSize)+"до");
                txtSize -= 2;
                Log.d("ggs",String.valueOf(txtSize)+"после");
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, txtSize);
                Log.d("ggs",String.valueOf(txtSize));
                Log.d("ggs",String.valueOf(textView.getTextSize()));
                break;
            case R.id.menu_bol:
                Log.d("ggs",String.valueOf(txtSize)+"до");
                txtSize += 2;
                Log.d("ggs",String.valueOf(txtSize)+"после");
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, txtSize);
                Log.d("ggs",String.valueOf(txtSize));
                textView.setText("Bol");
                break;

            case R.id.menu_exit:
                finish();
                break;
            case R.id.menu_std:
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                Log.d("ggs",String.valueOf(txtSize));
                textView.setText("Bol");
                break;
        }
    }
}