package com.example.eestech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class WrongAnswer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_answer);
    }

    protected void onStart(){
        super.onStart();
        Button button = findViewById(R.id.tryagainb);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                SharedPreferences level = getSharedPreferences("Level", Context.MODE_PRIVATE);
                int lvl = level.getInt("keyForLevel", 0);
                switch(lvl) {
                    case 1:
                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(), Level2Activity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getApplicationContext(), Level3Activity.class);
                        startActivity(intent3);
                        break;
                }
        }
    });
    }
}
