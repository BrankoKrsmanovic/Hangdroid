package com.example.hangdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over2);
        String failedWord = getIntent().getStringExtra("FAILED");

        TextView tv = (TextView) findViewById(R.id.failure);

        tv.setText(failedWord.toUpperCase());

    }

    public void startAgain(View v){
        Intent gameOver = new Intent(this,MainActivity.class);
        startActivity(gameOver);
    }
}
