package com.example.p1061_fragmentactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment frag2 = new Fragment2();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment2,frag2);
        ft.commit();
    }

    public void onClick(View view) {
        Fragment fragment1 = getSupportFragmentManager().findFragmentById(R.id.fragment1);
        ((TextView) fragment1.getView().findViewById(R.id.textView))
                .setText("Access to Fragment 1 from Activity");

        Fragment frag2 = getSupportFragmentManager().findFragmentById(R.id.fragment2);
        ((TextView) frag2.getView().findViewById(R.id.textView))
                .setText("Access to Fragment 2 from Activity");
    }
}