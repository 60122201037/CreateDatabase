package com.pure.createdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button btnshowscore , btntest ;
    FirebaseAuth mFirebaseAuth;


    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    btnshowscore = (Button)findViewById(R.id.btn_score);
    btnshowscore.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent a = new Intent(MainActivity.this,SubmitScore.class);
            startActivity(a);

        }
    });
    btntest = (Button)findViewById(R.id.btnstart);
    btntest.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Intent f = new Intent(MainActivity.this,QuizActivity.class);
        startActivity(f);
        }
    });





    }
}
