package com.example.yana.game_chislo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class game1 extends AppCompatActivity {

    TextView vvv;
    Integer ch1;
    Integer ch2;
    Integer ch01;
    Integer ch02;
    Integer klmn;
    Integer ch00;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        Intent intent = getIntent();
        String cos1 = intent.getStringExtra("cos1");
        String cos2 = intent.getStringExtra("cos2");

        ch01 = Integer.parseInt(cos1);
        ch02 = Integer.parseInt(cos2);

        ch1 = ch01;
        ch2 = ch02 / 2;
        klmn = 0;

        vvv = (TextView) findViewById(R.id.vvv);
        vvv.setText("От " + ch1 + " до" + ch2);
    }

    public void But(View v) {
        if (klmn == 0) {
            switch (v.getId()) {
                case R.id.button1:
                    //если число в интервале
                    ch02 = ch2;
                    ch2 = ch1 + (ch2 - ch1) / 2;
                    break;
                case R.id.button2:
                    //число не в интервале
                    ch01 = ch2;
                    ch1 = ch2 + 1;
                    ch2 = ch1 + (ch02 - ch1) / 2;
                    break;
            }
            vvv.setText("От " + ch1 + " до" + ch2);

            int ch = ch2 - ch1;
            if ((ch < 1)) {
                vvv.setText("Это " + ch1 + "?");
                klmn = 1;
            }
        } else {
            switch (v.getId()) {
                case R.id.button1:
                    //если число отгадано(ch1)
                    ch00 = ch01;
                    break;
                case R.id.button2:
                    //число не отгадано(ch2)
                    ch00 = ch02;
                    break;
            }
            Intent intent1 = new Intent(this, Final.class);
            intent1.putExtra("ch00", (Integer.toString(ch00)));
            startActivity(intent1);
        }

    }


}