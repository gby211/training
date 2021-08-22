package com.example.p0211twoactivity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnActTwo;
    public static int tmpp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tmpp+=1;
        btnActTwo = findViewById(R.id.btnActTwo);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnActTwo:
                Intent intent = new Intent(this, ActivityTwo.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ggs",tmpp + "start");
        tmpp++;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ggs",tmpp +"destroy");
        tmpp++;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ggs",tmpp +"restart");
        tmpp++;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ggs",tmpp +"resume");
        tmpp++;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ggs",tmpp +"pause");
        tmpp++;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ggs",tmpp +"stop");
        tmpp++;
    }
}