package com.example.p0491_simpleadaptercustom1;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MySimpleAdapter extends SimpleAdapter {

    final int positive = android.R.drawable.arrow_up_float;
    final int negative = android.R.drawable.arrow_down_float;


    public MySimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }

    @Override
    public void setViewText(TextView v, String text) {
        super.setViewText(v, text);
        if (v.getId() == R.id.tvValue) {
            int i = Integer.parseInt(text);
            if (i < 0) v.setTextColor(Color.RED); else
                if (i > 0) v.setTextColor(Color.GREEN);
        }
    }

    @Override
    public void setViewImage(ImageView v, int value) {
        super.setViewImage(v, value);
        if (value == negative) v.setBackgroundColor(Color.RED); else
        if (value == positive) v.setBackgroundColor(Color.GREEN);
    }
}
