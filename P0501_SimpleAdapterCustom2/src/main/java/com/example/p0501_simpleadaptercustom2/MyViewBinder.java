package com.example.p0501_simpleadaptercustom2;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class MyViewBinder extends AppCompatActivity implements SimpleAdapter.ViewBinder {
    int RED = getColor(R.color.Red);
    int GREEN = getColor(R.color.Green);
    int ORANGE = getResources().getColor(R.color.Orange, getTheme());


    @Override
    public boolean setViewValue(View view, Object o, String s) {
        int i = 0;
        switch (view.getId()) {
            case R.id.llLoad:
                i = (Integer) o;
                if (i < 40) view.setBackgroundColor(RED);
                else if (i < 70) view.setBackgroundColor(ORANGE);
                else
                    view.setBackgroundColor(GREEN);
                // ProgressBar
            case R.id.pbLoad:
                i = (Integer) o;
                ((ProgressBar) view).setProgress(i);
                return true;
        }
        return false;
    }
}
