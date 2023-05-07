package com.example.eestech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Completed extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed);
    }
    protected void onStart(){
        super.onStart();
        TextView levelstxt = findViewById(R.id.levelsText);
    }

    public void level1(View v){


        SharedPreferences level = getSharedPreferences("Level", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = level.edit();
        editor.putInt("keyForLevel",1);
        editor.commit();
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(intent);
    }
    public void level2(View v){
        SharedPreferences level = getSharedPreferences("Level", Context.MODE_PRIVATE);
        int lvl = level.getInt("keyForLevel", 0);
        boolean isPlayed=level.getBoolean("keyForLevel2",false);
        if(isPlayed==false) {
            Toast toast=Toast.makeText(getApplicationContext(), "Too low on level!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            SharedPreferences.Editor editor = level.edit();
            editor.putInt("keyForLevel", 2);
            editor.commit();
            Intent intent = new Intent(getApplicationContext(), Level2Activity.class);
            startActivity(intent);
        }
    }
    public void level3(View v){
        SharedPreferences level = getSharedPreferences("Level", Context.MODE_PRIVATE);
        int lvl = level.getInt("keyForLevel", 0);
        boolean isPlayed=level.getBoolean("keyForLevel3",false);
        if(isPlayed==false) {
            Toast toast=Toast.makeText(getApplicationContext(), "Too low on level!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            SharedPreferences.Editor editor = level.edit();
            editor.putInt("keyForLevel",3);
            editor.commit();
            Intent intent = new Intent(getApplicationContext(), Level3Activity.class);
            startActivity(intent);
        }
    }
    public void menu(View v){
        SharedPreferences level = getSharedPreferences("Level", Context.MODE_PRIVATE);
        int lvl = level.getInt("keyForLevel", 0);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

}