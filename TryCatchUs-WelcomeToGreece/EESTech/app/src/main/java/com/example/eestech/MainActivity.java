package com.example.eestech;

import static java.lang.System.exit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    protected void onStart(){
        super.onStart();
        SharedPreferences level = getSharedPreferences("Level", Context.MODE_PRIVATE);
        boolean isPlayed = level.getBoolean("keyForLevel1", false);
        int lvl = level.getInt("keyForLevel", 1);
        if(lvl>1){
            Button startbutton = findViewById(R.id.buttonStart);
            startbutton.setText("Continue");
        }
    }

    public void toRestart(View view){
        SharedPreferences level = getSharedPreferences("Level", Context.MODE_PRIVATE);
        int lvl = level.getInt("keyForLevel", 0);
        SharedPreferences.Editor editor = level.edit();
        editor.putInt("keyForLevel", 1);
        editor.putBoolean("keyForLevel1", false);
        editor.putBoolean("keyForLevel2",false);
        editor.putBoolean("keyForLevel3", false);
        editor.commit();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
     public void startCl(View view){
         SharedPreferences level = getSharedPreferences("Level", Context.MODE_PRIVATE);
         int lvl = level.getInt("keyForLevel", 0);
         switch(lvl) {
             case 0:
                 lvl++;
                 SharedPreferences.Editor editor = level.edit();
                 editor.putInt("keyForLevel", lvl);
                 editor.commit();
                 Intent intent0 = new Intent(getApplicationContext(), MainActivity2.class);
                 startActivity(intent0);
                 break;
             case 1:
                 Intent intenta = new Intent(getApplicationContext(), MainActivity2.class);
                 startActivity(intenta);
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
     @Override
     public void onBackPressed(){
       super.onBackPressed();
        finish();
     }
     @Override
     public void onDestroy(){
        super.onDestroy();
        finish();
     }
     public void toCompleted(View vi){
        Intent completed = new Intent(getApplicationContext(),Completed.class);
        startActivity(completed);
     }



}
