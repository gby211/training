package com.example.p0331_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.p0331_sharedpreferences.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etText;
    Button btnSave, btnLoad;

    int tmpp = 0;

    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_tex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = findViewById(R.id.etText);

        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        loadText();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("ggs",tmpp +"destroy");
        tmpp++;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLoad:
                loadText();
                break;
            case R.id.btnSave:
                saveText();
                break;
            default:
                break;
        }
    }

    void saveText(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etText.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    void loadText(){
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        etText.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ggs",tmpp + "start");
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
        saveText();
        Log.d("ggs",tmpp +"stop");
        tmpp++;
    }
}