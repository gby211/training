package com.example.p0621_alertdialogitems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    final int DIALOG_ITEMS = 1;
    final int DIALOG_ADAPTER = 2;
    final int DIALOG_CURSOR = 3;
    int cnt = 0;
    DB db;
    Cursor cursor;

    String data[] = { "one", "two", "three", "four" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DB(this);
        db.open();

        cursor = db.getAllData();
        //startManagingCursor(cursor);
    }









    public void onclick(View view) {
        CustomDialog myDialogFragment = new CustomDialog();
        FragmentManager manager = getSupportFragmentManager();
        switch (view.getId()){
            case R.id.btnItems:
                myDialogFragment.show(manager, "dialog");
                break;
            case R.id.btnAdapter:
                myDialogFragment.show(manager, "dialog2");
                break;
            case R.id.btnCursor:
                myDialogFragment.show(manager, "dialog3");
                break;
            case R.id.btnView:
                myDialogFragment.show(manager, "dialog4");
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        myDialogFragment.dismiss(); // when the task active then close the dialog
                        timer.cancel(); // also just top the timer thread, otherwise,
                        // you may receive a crash report
                    }
                }, 5000); // через 5 секунд (5000 миллисекунд), the task will be active.
                break;

        }


//        FragmentTransaction transaction = manager.beginTransaction();
//        myDialogFragment.show(transaction, "dialog");
    }
}