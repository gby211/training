package com.example.p0881_asynctaskresult;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

class MyTask extends AsyncTask<Void, Void, Integer> {

    WeakReference<Activity> mWeakActivity;

    public MyTask(Activity activity) {
        mWeakActivity = new WeakReference<Activity>(activity);
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        TextView tvInfo = mWeakActivity.get().findViewById(R.id.tvInfo);
        tvInfo.setText("Begin");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100500;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        ProgressBar pb = mWeakActivity.get().findViewById(R.id.pb);

        pb.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onPostExecute(Integer result) {
        ProgressBar pb = mWeakActivity.get().findViewById(R.id.pb);
        TextView tvInfo = mWeakActivity.get().findViewById(R.id.tvInfo);
        pb.setVisibility(View.GONE);
        super.onPostExecute(result);
        tvInfo.setText("End. Result = " + result);
    }
}
