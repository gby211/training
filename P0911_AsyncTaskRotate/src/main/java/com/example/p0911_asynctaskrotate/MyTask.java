package com.example.p0911_asynctaskrotate;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

class MyTask extends AsyncTask<String, Integer, Void> {

    WeakReference<Activity> mWeakActivity;

    public MyTask(Activity activity) {
        mWeakActivity = new WeakReference<Activity>(activity);
    }

    @Override
    protected Void doInBackground(String... params) {
        try {
            for (int i = 1; i <= 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                publishProgress(i);
                Log.d("myLogs", "i = " + i
                        + ", MyTask: " + this.hashCode()
                        + ", MainActivity: " + mWeakActivity.hashCode());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        TextView tv = mWeakActivity.get().findViewById(R.id.tv);
        tv.setText("i = " + values[0]);
    }
}
