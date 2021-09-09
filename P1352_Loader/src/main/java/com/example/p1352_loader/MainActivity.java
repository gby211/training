package com.example.p1352_loader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.database.ContentObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    final String LOG_TAG = "myLogs";
    static final int LOADER_TIME_ID = 404;

    TextView tvTime;
    RadioGroup rgTimeFormat;
    ProgressBar pb;
    static int lastCheckedId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTime = (TextView) findViewById(R.id.tvTime);
        rgTimeFormat = (RadioGroup) findViewById(R.id.rgTimeFormat);

        pb = findViewById(R.id.progressBar);
        pb.setVisibility(View.GONE);
        Bundle bndl = new Bundle();
        bndl.putString(TimeLoader.ARGS_TIME_FORMAT, getTimeFormat());
        LoaderManager.getInstance(this).initLoader(LOADER_TIME_ID, bndl, this);
        lastCheckedId = rgTimeFormat.getCheckedRadioButtonId();
    }
    // ЭТО С Loader, а не с asyncTaskLoader
//    @Override
//    public Loader<String> onCreateLoader(int id, Bundle args) {
//        Loader<String> loader = null;
//        if (id == LOADER_TIME_ID) {
//            loader = new TimeLoader(this, args);
//            Log.d(LOG_TAG, "onCreateLoader: " + loader.hashCode());
//        }
//        return loader;
//    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        Loader<String> loader = null;
        if (id == LOADER_TIME_ID) {
            loader = new TimeAsyncLoader(this,  args);
            Log.d(LOG_TAG, "onCreateLoader: " + loader.hashCode());
        }
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String result) {
        Log.d(LOG_TAG, "onLoadFinished for loader " + loader.hashCode()
                + ", result = " + result);
        tvTime.setText(result);
        pb.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {
        Log.d(LOG_TAG, "onLoaderReset for loader " + loader.hashCode());
    }

    public void getTimeClick(View v) {
        Loader<String> loader;
        pb.setVisibility(View.VISIBLE);
        int id = rgTimeFormat.getCheckedRadioButtonId();
        if (id == lastCheckedId) {
            loader = LoaderManager.getInstance(this).getLoader(LOADER_TIME_ID);
        } else {
            Bundle bndl = new Bundle();
            bndl.putString(TimeLoader.ARGS_TIME_FORMAT, getTimeFormat());
            LoaderManager.LoaderCallbacks<String> loaderCallbacks = this;
            loader = LoaderManager.getInstance(this).restartLoader(LOADER_TIME_ID, bndl, this);
            lastCheckedId = id;
        }
        loader.forceLoad();
    }

    String getTimeFormat() {
        String result = TimeLoader.TIME_FORMAT_SHORT;
        switch (rgTimeFormat.getCheckedRadioButtonId()) {
            case R.id.rdShort:
                result = TimeLoader.TIME_FORMAT_SHORT;
                break;
            case R.id.rdLong:
                result = TimeLoader.TIME_FORMAT_LONG;
                break;
        }
        return result;
    }

    public void observerClick(View v) {
        Log.d(LOG_TAG, "observerClick");
        Loader<String> loader = LoaderManager.getInstance(this).getLoader(LOADER_TIME_ID);
        assert loader != null;
        final ContentObserver observer = loader.new ForceLoadContentObserver();
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                observer.dispatchChange(false,null);
            }
        }, 5000);
    }
}