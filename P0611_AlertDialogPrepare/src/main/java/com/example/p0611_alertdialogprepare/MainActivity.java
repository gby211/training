package com.example.p0611_alertdialogprepare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    final static String LOG_TAG = "myLogs";
    final int DIALOG = 1;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        CustomDialog dialog = new CustomDialog();
        dialog.show(getSupportFragmentManager(),"custom");
    }

}