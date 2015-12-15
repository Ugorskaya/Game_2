package com.example.yana.game_chislo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
    }

    public void ONok(View v) {
        Intent intent = new Intent(this, game1.class);

        intent.putExtra("cos1", editText1.getText().toString());
        intent.putExtra("cos2", editText2.getText().toString());

        startActivity(intent);
    }
}
