package com.example.p0911_asynctaskrotate;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

class MyTask extends AsyncTask<String, Integer, Void> {

    private final MainActivity mainActivity;

    public MyTask(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected Void doInBackground(String... params) {
        try {
            for (int i = 1; i <= 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                publishProgress(i);
                Log.d("qwe", "i = " + i
                        + ", MyTask: " + this.hashCode()
                        + ", MainActivity: " + mainActivity.hashCode());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mainActivity.tv.setText("i = " + values[0]);
    }
}
