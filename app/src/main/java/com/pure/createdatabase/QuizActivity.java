package com.pure.createdatabase;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private QuestionLibary mQuestionLibrary = new QuestionLibary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    MediaPlayer musics ;
    private  Button buttonplay, buttonstop;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private int [] musiccle = {R.raw.music1};
    private String musicArray[] = new String[10];
    private String score= "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        score = getIntent().getStringExtra("score");
        buttonplay = (Button) findViewById(R.id.btnplay);

        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        musicArray[0] = getResources().getResourceEntryName(R.raw.music1);
        musicArray[1] = getResources().getResourceEntryName(R.raw.music2);
        musicArray[2] = getResources().getResourceEntryName(R.raw.music3);
        musicArray[3] = getResources().getResourceEntryName(R.raw.music4);
        musicArray[4] = getResources().getResourceEntryName(R.raw.music5);
        musicArray[5] = getResources().getResourceEntryName(R.raw.music6);
        musicArray[6] = getResources().getResourceEntryName(R.raw.music7);
        musicArray[7] = getResources().getResourceEntryName(R.raw.music8);
        musicArray[8] = getResources().getResourceEntryName(R.raw.music9);
        musicArray[9] = getResources().getResourceEntryName(R.raw.music10);



        updateQuestion();
        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        })
        ;

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button3

    }

    private void updateQuestion(){
        int resID = getResources().getIdentifier(musicArray[mQuestionNumber],"raw", getPackageName());
        musics = MediaPlayer.create(QuizActivity.this, resID);
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoicel(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);

        buttonplay.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musics.start();

            }
        });



        if(mQuestionNumber < 9 ) {
            mQuestionNumber++;
        }

        else{ Intent a = new Intent(QuizActivity.this,SubmitScore.class);
            score = getIntent().getStringExtra("score");
            a.putExtra("score",score);
            startActivity(a);



        }

//
    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }



}