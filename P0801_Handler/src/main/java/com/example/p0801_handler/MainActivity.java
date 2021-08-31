package com.example.p0801_handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
/////////// DEPRECATED УСТАРЕЛО!!!
import android.os.Handler;/////////// DEPRECATED УСТАРЕЛО!!!
/////////// DEPRECATED УСТАРЕЛО!!!
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    /////////// DEPRECATED УСТАРЕЛО!!!
    Handler h;
    TextView tvInfo;
    Button btnStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView) findViewById(R.id.textView);
        btnStart = (Button) findViewById(R.id.btnStart);

        /////////// DEPRECATED УСТАРЕЛО!!!
        h = new Handler() {
            public void handleMessage(android.os.Message msg) {
                // обновляем TextView
                tvInfo.setText("Закачано файлов: " + msg.what);
                if (msg.what == 10) btnStart.setEnabled(true);
            };
        };
        /////////// DEPRECATED УСТАРЕЛО!!!
    }

    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for (int i = 1; i <= 10; i++) {
                            // долгий процесс
                            downloadFile();
                            // обновляем TextView
                            tvInfo.setText("Закачано файлов: " + i);
                            // пишем лог
                            Log.d(LOG_TAG, "Закачано файлов: " + i);
                        }
                    }
                });
                t.start();
                break;
            case R.id.btnTest:
                Log.d(LOG_TAG, "test");
                break;
            default:
                break;
        }
    }

    void downloadFile() {
        // пауза - 1 секунда
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}