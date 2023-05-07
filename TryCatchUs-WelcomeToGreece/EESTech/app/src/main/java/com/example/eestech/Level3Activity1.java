package com.example.eestech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

public class Level3Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level31);
    }
    protected void onStart(){
        super.onStart();
        Button next = findViewById(R.id.button2);
        TextView header = findViewById(R.id.parthenonCor);
        TextView info = findViewById(R.id.ParthenonInfo);
        info.setText("Thessaloniki is the second largest town of Greece\nDue to fire, the town was rebuilt in 1917 by Ernest Hebrard.");
        header.setText("Correct!\nWhite Tower is located in Thessaloniki");
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Level3Activity2.class);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

}

