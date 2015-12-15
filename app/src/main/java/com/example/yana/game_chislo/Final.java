package com.example.yana.game_chislo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Final extends AppCompatActivity {

    TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent intent1 = getIntent();

        textView6= (TextView) findViewById(R.id.textView6);
        textView6.setText("Ваше число " + intent1.getStringExtra("ch00") + "!");
        }
    public void Click1(View v) {
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }

}
