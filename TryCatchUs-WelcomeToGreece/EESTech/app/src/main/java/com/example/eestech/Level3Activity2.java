package com.example.eestech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Level3Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level32);
    }
    public void goMenu(View v){
        Intent intent = new Intent(getApplicationContext(),ActivityEnd.class);
        startActivity(intent);
    }
}