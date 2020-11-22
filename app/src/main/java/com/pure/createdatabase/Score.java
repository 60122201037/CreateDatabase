package com.pure.createdatabase;

public class Score {
    private String scores;
    private String username;

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Score(String scores, String username) {
        this.scores = scores;
        this.username = username;
    }

    public Score() {
    }
}
