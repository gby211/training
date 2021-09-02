package com.example.p0911_asynctaskrotate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyTask mt;
    TextView tv;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("myLogs", "create MainActivity: " + this.hashCode());

        tv = (TextView) findViewById(R.id.tv);

        mt = new MyTask(this);
        Log.d("myLogs", "create MyTask: " + mt.hashCode());
        mt.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

}