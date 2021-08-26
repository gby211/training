package com.example.p0452_expandablelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] mGroupsArray = new String[]{"Зима", "Весна", "Лето", "Осень"};

    private String[] mWinterMonthsArray = new String[]{"Декабрь", "Январь", "Февраль"};
    private String[] mSpringMonthsArray = new String[]{"Март", "Апрель", "Май"};
    private String[] mSummerMonthsArray = new String[]{"Июнь", "Июль", "Август"};
    private String[] mAutumnMonthsArray = new String[]{"Сентябрь", "Октябрь", "Ноябрь"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Map<String, String> map;
        ArrayList<Map<String, String>> groupDataList = new ArrayList<>();

        for (String nameG : mGroupsArray) {
            map = new HashMap<>();
            map.put("groupName", nameG);
            groupDataList.add(map);
        }

        String groupFrom[] = new String[]{"groupName"};
        int groupTo[] = new int[]{R.id.text1};

        ArrayList<ArrayList<Map<String, String>>> childDataList = new ArrayList<>();

        ArrayList<Map<String, String>> childDataItemList = new ArrayList<>();

        for (String month : mWinterMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        for (String month : mSpringMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        for (String month : mSummerMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        for (String month : mAutumnMonthsArray) {
            map = new HashMap<>();
            map.put("monthName", month);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        String[] childFrom = new String[]{"monthName"};
        int [] childTo = new int[]{R.id.text1};
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(this, groupDataList, R.layout.my_list_item, groupFrom, groupTo, childDataList, R.layout.my_expandeble_list_item, childFrom, new int[]{R.id.text1});

    }
}