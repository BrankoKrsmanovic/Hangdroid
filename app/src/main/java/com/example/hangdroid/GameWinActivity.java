package com.example.hangdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameWinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win);
    }

    public void startAgain(View v){
        Intent gameOver = new Intent(this,MainActivity.class);
        startActivity(gameOver);
    }
}
