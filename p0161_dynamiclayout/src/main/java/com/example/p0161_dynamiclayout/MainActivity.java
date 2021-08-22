package com.example.p0161_dynamiclayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    LinearLayout llMain;
    RadioGroup rgGravity;
    EditText etName;
    Button btnCreate;
    Button btnClear;

    public static int tmpp = 0;

    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ggs",tmpp +"create");
        tmpp++;


        llMain =  findViewById(R.id.llMain);
        rgGravity = findViewById(R.id.rgGravity);
        etName = findViewById(R.id.etName);
    }

    public void btnCreated(View v){
        switch (v.getId()){
            case R.id.btnCreate:
                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent,wrapContent);
                int btnGravity = Gravity.LEFT;
                switch (rgGravity.getCheckedRadioButtonId()){
                    case R.id.rbLeft:
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.rbCenter:
                        btnGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.rbRight:
                        btnGravity = Gravity.RIGHT;
                        break;
                }
                lParams.gravity = btnGravity;

                Button btnNew = new Button(this);
                btnNew.setText(etName.getText().toString());
                llMain.addView(btnNew, lParams);

                break;
            case R.id.btnClear:
                llMain.removeAllViews();
                Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ggs",tmpp + "start");
        tmpp++;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ggs",tmpp +"destroy");
        tmpp++;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ggs",tmpp +"restart");
        tmpp++;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ggs",tmpp +"resume");
        tmpp++;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ggs",tmpp +"pause");
        tmpp++;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ggs",tmpp +"stop");
        tmpp++;
    }
}