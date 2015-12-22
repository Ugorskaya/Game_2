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
        klmn = 0;
        vvv = (TextView) findViewById(R.id.vvv);

        if (ch01>ch02){ch01=ch02;ch02=Integer.parseInt(cos1);}//правильный порядок
        if((ch02-ch01)==1){klmn=1;vvv.setText("Это " + ch01 + "?");}//интервал 1
        else if((ch02-ch01)==0){ch00=ch01;Bb1();}//если интервал 0
        else{
        ch1 = ch01;
        ch2 = ch01+(ch02 -ch01)/2;

        vvv.setText("От " + ch1 + " до " + ch2);
         }}


    public void But(View v) {//интервал больше 1
        if (klmn == 0) {
            //подсчет интервала
            switch (v.getId()) {
                case R.id.button1:
                    //если число в интервале
                    ch01 = ch1;
                    ch02 = ch2;
                    ch2 = ch1 + (ch2 - ch1) / 2;
                    break;
                case R.id.button2:
                    //число не в интервале
                    ch01 = ch2+1;
                    ch1 = ch01;
                    ch2 = ((ch02-ch01)/2)+ch01;
                    break;
            }

            //проверка интервала
            int ch = ch02 - ch01;
            if ((ch == 1)) {//если равно 1
                vvv.setText("Это " + ch01 + "?");
                klmn = 1;
            }
            else if(ch == 0){//если равно 0
                ch00=ch01;
                Bb1();
            }
            else{//если больше 1
                vvv.setText("От " + ch1 + " до" + ch2);
            }

        } else {
            if (klmn == 1) {//если равно 1

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
                Bb1();
            }
        }
    }

    private void Bb1() {
        Intent intent1 = new Intent(this, Final.class);
        intent1.putExtra("ch00", (Integer.toString(ch00)));
        startActivity(intent1);
    }


}