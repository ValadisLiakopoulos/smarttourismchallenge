package com.example.eestech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Level2Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level22);
    }
    protected void onStart() {
        super.onStart();
        final Button nextButton = findViewById(R.id.button2);
        nextButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Level3Activity.class);
                startActivity(intent);
            }
        });
    }
}