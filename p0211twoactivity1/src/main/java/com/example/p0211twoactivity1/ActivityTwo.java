package com.example.p0211twoactivity1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;



public class ActivityTwo extends AppCompatActivity {
    public static int tmpp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ggs",tmpp + " start2");
        tmpp++;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ggs",tmpp +" destroy2");
        tmpp++;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ggs",tmpp +" restart2");
        tmpp++;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ggs",tmpp +" resume2");
        tmpp++;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ggs",tmpp +" pause2");
        tmpp++;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ggs",tmpp +" stop2");
        tmpp++;
    }
}