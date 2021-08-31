package com.example.p0861_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    MyTask mt;
    TextView tvInfo;
    final String LOG_TAG = "myLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = findViewById(R.id.tvInfo);
    }

    public void onClick(View view) {
        mt = new MyTask();
        mt.execute(); //выполнение происходит парралельно но в одном потоке который имеет очередь
        // Дело в том , что с API11 запуск потока через execute() ставит все следующие после первого потоки в очередь и они дожидаются окончания выполнения предыдущих , то есть задачи выполняются последовательно , а не параллельно.

        /// ВЫПОЛЕНИЕ ВСЕХ ПОТОКОВ ОДНОВРЕМЕННО, в разынх потоках
        /// mt.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    class MyTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvInfo.setText("Begin");
            Log.d(LOG_TAG, "onPreExecute");

        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d(LOG_TAG, "doInBackground");
            try{
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Log.d(LOG_TAG, "onPostExecute");
            tvInfo.setText("End");
        }
    }
}