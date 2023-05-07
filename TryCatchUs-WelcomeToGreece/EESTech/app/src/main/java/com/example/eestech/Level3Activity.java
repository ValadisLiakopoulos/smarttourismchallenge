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

public class Level3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
    }
    protected void onStart() {
        super.onStart();
        SharedPreferences level = getSharedPreferences("Level", Context.MODE_PRIVATE);
        int lvl = level.getInt("keyForLevel", 0);
        boolean isPlayed = level.getBoolean("keyForLevel3", false);
        TextView textView = findViewById(R.id.level1);
        String txtlevel = getString(R.string.whitetowerheader, lvl);
        textView.setText(txtlevel);
        RadioButton radioButton1 = findViewById(R.id.multipleoption1_1);
        radioButton1.setText("Athens");
        RadioButton radioButton2 = findViewById(R.id.multipleoption1_2);
        radioButton2.setText("Thessaloniki");
        RadioButton radioButton3 = findViewById(R.id.multipleoption1_3);
        radioButton3.setText("Patras");
        RadioGroup radioGroup = findViewById(R.id.groupMultiple_1);

        Button submitButton = findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast text = Toast.makeText(getApplicationContext(), "You didn't choose a button!", Toast.LENGTH_SHORT);
                    text.show();
                } else {
                    if (selectedRadioButton.getText().equals("Thessaloniki")) {
                        SharedPreferences level = getSharedPreferences("Level", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = level.edit();
                        editor.putBoolean("keyForLevel3", true);
                        Intent intent = new Intent(getApplicationContext(), Level3Activity1.class);
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