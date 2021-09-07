package com.example.p1091_listfragment;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class MainList extends ListFragment {
    String data[] = new String[]{"one", "two", "three", "four"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);
    }
}
