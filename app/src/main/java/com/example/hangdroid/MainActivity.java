package com.example.hangdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startGame(View v) {

        EditText editText = findViewById(R.id.editTextWord);
        String wordtoGuess = editText.getText().toString();

        if (wordtoGuess.length() < 1)
            Toast.makeText(this, "Word must have one letter, at least!", Toast.LENGTH_SHORT).show();
        else if(wordtoGuess.contains(" ") || wordtoGuess.contains("\n") || wordtoGuess.contains("\t")) {
            Toast.makeText(this, "Whitespaces are not allowed!", Toast.LENGTH_SHORT).show();
            editText.setText("");
        }
        else {
            Intent myIntent = new Intent(this, GameActivity.class);
            myIntent.putExtra("WORD_IDENTIFIER", wordtoGuess);
            startActivity(myIntent);
            editText.setText("");
        }
    }



}
