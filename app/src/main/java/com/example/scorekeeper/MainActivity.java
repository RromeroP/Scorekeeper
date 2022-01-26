package com.example.scorekeeper;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    int team1Score = 0;
    int team2Score = 0;

    String STATE_SCORE_1;
    String STATE_SCORE_2;

    TextView team1Counter;
    TextView team2Counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        team1Counter = findViewById(R.id.team1_score);
        team2Counter = findViewById(R.id.team2_score);

        if (savedInstanceState != null) {
            team1Score = savedInstanceState.getInt(STATE_SCORE_1);
            team2Score = savedInstanceState.getInt(STATE_SCORE_2);
            //Set the score text views
            team1Counter.setText(String.valueOf(team1Score));
            team2Counter.setText(String.valueOf(team2Score));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(STATE_SCORE_1, team1Score);
        outState.putInt(STATE_SCORE_2, team2Score);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            AppCompatDelegate.getDefaultNightMode();
        }

        int nightMode = AppCompatDelegate.getDefaultNightMode();

        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        return super.onOptionsItemSelected(item);
    }

    public void decreaseScore(View view) {
        switch (view.getId()) {
            case R.id.team1_button1:
                if (team1Score > 0) team1Score -= 1;
                team1Counter.setText(String.valueOf(team1Score));
                break;
            case R.id.team2_button1:
                if (team2Score > 0) team2Score -= 1;
                team2Counter.setText(String.valueOf(team2Score));
                break;
        }
    }

    public void increaseScore(View view) {
        switch (view.getId()) {
            case R.id.team1_button2:
                team1Score += 1;
                team1Counter.setText(String.valueOf(team1Score));
                break;
            case R.id.team2_button2:
                team2Score += 1;
                team2Counter.setText(String.valueOf(team2Score));
                break;
        }
    }
}