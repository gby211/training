package com.example.p0771_tabintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class two extends AppCompatActivity {
    private String LOG_TAG = "myLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Log.d(LOG_TAG, "2onCreate");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "2onDestroy");
    }

    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "2onPause");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "2onRestart");
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(LOG_TAG, "2onRestoreInstanceState");
    }

    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "2onResume ");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, "2onSaveInstanceState");
    }

    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "2onStart");
    }

    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "2onStop");
    }
}