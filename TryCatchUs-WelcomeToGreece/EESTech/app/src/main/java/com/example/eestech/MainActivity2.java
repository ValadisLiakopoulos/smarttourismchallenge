package com.example.eestech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginlevels);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
    }
    protected void onStart(){
        super.onStart();
        SharedPreferences level = getSharedPreferences("Level", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = level.edit();
        boolean isPlayed = level.getBoolean("keyForLevel1", false);
        int lvl = level.getInt("keyForLevel", 0);
        TextView textView = findViewById(R.id.level1);
        String txtlevel = getString(R.string.firstLevel, lvl);
        textView.setText(txtlevel);
        RadioButton radioButton1 = findViewById(R.id.multipleoption1_1);
        RadioButton radioButton2 = findViewById(R.id.multipleoption1_2);
        RadioButton radioButton3 = findViewById(R.id.multipleoption1_3);
        RadioGroup radioGroup = findViewById(R.id.groupMultiple_1);
        Button submitButton = findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast text = Toast.makeText(getApplicationContext(), "You didn't choose a button!", Toast.LENGTH_SHORT);
                    text.show();
                } else {
                    if (selectedRadioButton.getText().equals("Parthenon")) {
                        SharedPreferences level = getSharedPreferences("Level", Context.MODE_PRIVATE);
                        int lvl2 = level.getInt("keyForLevel", 0);
                        SharedPreferences.Editor editor = level.edit();
                        lvl2++;
                        editor.putInt("keyForLevel", lvl2);
                        editor.putBoolean("keyForLevel2", true);
                        editor.commit();
                        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), WrongAnswer.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
