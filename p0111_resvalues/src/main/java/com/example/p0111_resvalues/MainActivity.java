package com.example.p0111_resvalues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView bottomTextView;
    Button bottomBtn;
    LinearLayout bottomLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomBtn = findViewById(R.id.btnBottom);
        bottomTextView = findViewById(R.id.tvBottom);
        bottomLL = findViewById(R.id.llBottom);

        Log.d("ggs","gg");
        bottomLL.setBackgroundResource(R.color.llBottomColor);
        bottomBtn.setText(R.string.btnBottomText);
        bottomTextView.setText(R.string.tvBottomText);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub

        menu.add("menu1");
        menu.add("menu2");
        menu.add("menu3");
        menu.add("menu4");

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }


    public void ggs(View view) {
        switch (view.getId()){
            case(R.id.btnTop):
                Toast.makeText(this, "Кнопка верхняя нажата", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.btnBottom):
                Toast.makeText(this, "Кнопка нижння нажата", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}