package com.example.court_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int team_A_Score = 0;
    int team_B_Score = 0;

    public void freeThrow_A(View view) {
        team_A_Score += 1;
        displayScoreForA(team_A_Score);
    }

    private void displayScoreForA(int score){
        TextView scoreA = (TextView) findViewById(R.id.team_a_score);
        scoreA.setText("" + score);
    }

    public void UpdateTeamA_ScoreToTwo(View view) {
        team_A_Score +=2;
        displayScoreForA(team_A_Score);
    }

    public void UpdateTeamA_ScoreToThree(View view) {
        team_A_Score +=3;
        displayScoreForA(team_A_Score);
    }

    private void displayScoreForB(int score){
        TextView scoreA = (TextView) findViewById(R.id.team_b_score);
        scoreA.setText("" + score);
    }

    public void UpdateTeam_B_ScoreToThree(View view) {
        team_B_Score +=3;
        displayScoreForB(team_B_Score);
    }

    public void UpdateTeam_B_ScoreToTwo(View view) {
        team_B_Score +=2;
        displayScoreForB(team_B_Score);
    }

    public void UpdateTeam_B_ScoreToOne(View view) {
        team_B_Score +=1;
        displayScoreForB(team_B_Score);
    }

    public void reset(View view) {
        team_A_Score =0;
        team_B_Score =0;
        displayScoreForA(team_A_Score);
        displayScoreForB(team_B_Score);
    }
}