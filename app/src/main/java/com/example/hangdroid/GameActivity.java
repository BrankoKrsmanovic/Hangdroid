package com.example.hangdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    String mWord;
    int mfailCounter = 0;
    int mPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        String wordSent = getIntent().getStringExtra("WORD_IDENTIFIER");
        mWord = wordSent;
        createTextViews(wordSent);
    }

    public void createTextViews(String word){
        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);

        for (int i = 0; i < word.length(); i++) {
            TextView newTextView = (TextView) getLayoutInflater().inflate(R.layout.text_view, null);
            layoutLetters.addView(newTextView);
        }
    }

    public void introduceLetter(View v){

        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);
        String letter = myEditText.getText().toString();

        if(letter.length() == 1) {
            checkedLetter(letter);
            myEditText.setText("");
        }
        else
            Toast.makeText(this, "Please introduce letter!", Toast.LENGTH_SHORT).show();
    }

    public void checkedLetter(String introducedLetter) {
        boolean letterGuessed = false;
        for (int i = 0; i < mWord.length(); i++) {
            if (mWord.toLowerCase().charAt(i) == introducedLetter.toLowerCase().charAt(0)){
                letterGuessed = true;
                showLetterAtIndex(i,introducedLetter.toUpperCase().charAt(0));
            }
        }
        if(!letterGuessed){
            letterFailed(introducedLetter.charAt(0));
        }
    }

    public  void letterFailed(char letter){

        TextView failedLetter = (TextView) findViewById(R.id.wrongLetters);
        failedLetter.append(letter + ", ");

        mfailCounter++;
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        switch (mfailCounter){
            case 1:{
                imageView.setImageResource(R.drawable.basicbg2);
                break;
            }
            case 2:{
                imageView.setImageResource(R.drawable.basicbg3);
                break;
            }
            case 3:{
                imageView.setImageResource(R.drawable.basicbg4);
                break;
            }
            case 4:{
                imageView.setImageResource(R.drawable.basicbg5);
                break;
            }
            case 5:{
                imageView.setImageResource(R.drawable.basicbg6);
                break;
            }
            case 6:{
                EditText et = (EditText) findViewById(R.id.editTextLetter);
                Button b = (Button) findViewById(R.id.button);
                b.setEnabled(false);
                et.setEnabled(false);

                imageView.setImageResource(R.drawable.basicbg7);
                Intent gameOver = new Intent(this,GameOverActivity.class);
                gameOver.putExtra("FAILED", mWord);
                startActivity(gameOver);
                break;
            }
        }
    }

    public void showLetterAtIndex(int position, char letterGuessed){
        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);
        TextView textView = (TextView) layoutLetter.getChildAt(position);

        if(!textView.getText().toString().equalsIgnoreCase(Character.toString(letterGuessed)))
            mPoints++;

        textView.setText(Character.toString(letterGuessed));

        if(mPoints == mWord.length()) {
            EditText et = (EditText) findViewById(R.id.editTextLetter);
            Button b = (Button) findViewById(R.id.button);
            b.setEnabled(false);
            et.setEnabled(false);
            Intent gameOver = new Intent(this, GameWinActivity.class);
            startActivity(gameOver);
        }
    }
}
