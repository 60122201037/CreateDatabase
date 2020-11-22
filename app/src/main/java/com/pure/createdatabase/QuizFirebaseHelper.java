package com.pure.createdatabase;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class QuizFirebaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceScore;
    private List<Score> scores =new ArrayList<>();

    public interface  DataStatus{
        void DataIsLoaded(List<Score> scores,List<String>keys);
        void  DataIsInserted();

    }
    public QuizFirebaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceScore = mDatabase.getReference("scores");
    }

    public QuizFirebaseHelper(String score) {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceScore = mDatabase.getReference(score);
    }


    public  void readScore(final  DataStatus dataStatus) {
        mReferenceScore.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                scores.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Score score = keyNode.getValue(Score.class);
                    scores.add(score);
                }
                dataStatus.DataIsLoaded(scores, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void addScore(Score score, final DataStatus dataStatus){
        String key = mReferenceScore.push().getKey();
        mReferenceScore.child(key).setValue(score)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsInserted();
                    }
                });
    }
}
