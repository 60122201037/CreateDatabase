package com.pure.createdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class SubmitScore extends AppCompatActivity {
    private String username;
    EditText user;
    Button btnSubmit;
    private String scoreValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_score);
        scoreValue = getIntent().getStringExtra("score");
        user = (EditText)findViewById(R.id.editText3);
        btnSubmit = (Button)findViewById(R.id.button5);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Score score = new Score();
                score.setScores(user.getText().toString());
                new FIrebasedatabaseHelper(scoreValue).addScore(score, new FIrebasedatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Score> scores, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(SubmitScore.this,"",Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent( SubmitScore.this,TestscoreActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }

}
