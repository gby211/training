package com.example.p0701_saveinstancestate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    final String LOG_TAG = "myLogs";
    int cnt = 0;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "onCreate");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cnt = savedInstanceState.getInt("count");
        Log.d(LOG_TAG, "------posle------"+ cnt);
        Log.d(LOG_TAG, "onRestoreInstanceState");
    }

    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume ");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",cnt);
        Log.d(LOG_TAG, "-----------" + cnt);
        Log.d(LOG_TAG, "onSaveInstanceState");
    }

    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

//    @Override
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        Log.d(LOG_TAG, "onAttachedToWindow");
//    }

    public void onClick(View v) {
        Toast.makeText(this, "Count = " + ++cnt, Toast.LENGTH_SHORT).show();
    }

}