package com.pure.createdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class TestscoreActivity extends AppCompatActivity {
    private RecyclerView rvShowScore;
    private TextView buttonfinish ;
    private String path= "scores";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testscore);
        buttonfinish = (TextView) findViewById(R.id.Finish);

        buttonfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(TestscoreActivity.this, MainActivity.class);
                startActivity(a);
            }
        });

        rvShowScore = (RecyclerView) findViewById(R.id.rv_showScore);
        rvShowScore.setLayoutManager(new LinearLayoutManager(TestscoreActivity.this));
        rvShowScore.setHasFixedSize(true);
        new FIrebasedatabaseHelper().readScore(new FIrebasedatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Score> scores, List<String> keys) {
                new RecycleView_Config().setConfig(rvShowScore, TestscoreActivity.this, scores, keys);
            }

            @Override
            public void DataIsInserted() {

            }
        });

    }
}
