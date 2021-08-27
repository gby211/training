package com.example.p0501_simpleadaptercustom2;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

class MyViewBinder extends MainActivity implements SimpleAdapter.ViewBinder {

    @Override
    public boolean setViewValue(View view, Object o, String s) {

        int RED = view.getResources().getColor(R.color.Red,null);
        int GREEN = view.getResources().getColor(R.color.Green,null);
        int ORANGE = view.getResources().getColor(R.color.Orange,null);

        int i = 0;
        switch (view.getId()) {
            case R.id.llLoad:
                i = (Integer) o;
                if (i < 40) view.setBackgroundColor(RED);
                else if (i < 70) view.setBackgroundColor(ORANGE);
                else
                    view.setBackgroundColor(GREEN);
                return true;
            // ProgressBar
            case R.id.pbLoad:
                i = ((Integer) o).intValue();
                ((ProgressBar)view).setProgress(i);
                return true;
        }
        return false;
    }
}