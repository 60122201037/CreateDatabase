package com.pure.createdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleView_Config {
    private Context mContext ;
    private ScoreAdapter mScoreAdapter ;
    public void setConfig(RecyclerView recyclerView,
                          Context context,
                          List<Score>scores , List<String>keys){
        mContext = context ;
        mScoreAdapter = new ScoreAdapter (scores , keys);
        recyclerView.setLayoutManager (new LinearLayoutManager(context));
        recyclerView.setAdapter (mScoreAdapter);
    }
    class  ScoreItemView extends  RecyclerView.ViewHolder{
        private TextView mDate;
        private  TextView mName;
        private  TextView mScore;
        private  String key;

        public  ScoreItemView (ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.score_list_item,parent,false));
            mName = (TextView)itemView.findViewById(R.id.txt_showName);
            mScore = (TextView)itemView.findViewById(R.id.txt_ShowScore);
        }
        public void bind (Score score ,String key ){
            mName.setText(score.getUsername());
            mScore.setText(score.getScores());
            this.key=key;
        }
    }
    class  ScoreAdapter extends RecyclerView.Adapter<ScoreItemView>  {
        private  List<Score>mScoreList;
        private  List<String>mKeys;

        public  ScoreAdapter (List<Score>mScoreList,List<String>mKeys){
            this.mScoreList = mScoreList;
            this.mKeys= mKeys;
        }

        @NonNull

        public ScoreItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ScoreItemView(parent);
        }


        public void onBindViewHolder(@NonNull ScoreItemView holder, int position) {
            holder.bind(mScoreList.get(position), mKeys.get(position));
        }


        public int getItemCount() {
            return mScoreList.size();
        }
    }
}




