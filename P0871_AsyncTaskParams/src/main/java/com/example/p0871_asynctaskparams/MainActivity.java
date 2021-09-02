package com.example.p0871_asynctaskparams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    MyTask mt;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {
    mt = new MyTask();
    mt.execute("file_path_1", "file_path_2", "file_path_3", "file_path_4");

    }

    class MyTask extends AsyncTask<String,Integer,Void>{

        @Override
        protected Void doInBackground(String... strings) {
            try {
                int cnt = 0;
                for (String url : strings) {
                    // загружаем файл
                    downloadFile(url);
                    // выводим промежуточные результаты
                    publishProgress(++cnt);
                }
                // разъединяемся
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tv.setText("Begin");
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tv.setText("Downloaded " + values[0] + " files");
        }

        private void downloadFile (String url) throws InterruptedException{
            TimeUnit.SECONDS.sleep(2);
        }
    }
}