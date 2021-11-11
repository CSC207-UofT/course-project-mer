package com.mer.plamer.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;

import com.mer.plamer.R;
import com.mer.plamer.usecases.PlayAction;

public class PlayerActivity extends AppCompatActivity {
    Button mPlayPauseButton;
    Button mPreviousButton;
    Button mNextButton;
    SeekBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initializeViews();
        defineActions();
    }

    private void initializeViews(){
        mPlayPauseButton = findViewById(R.id.playPauseButtonFull);
        mPreviousButton = findViewById(R.id.previousButtonFull);
        mNextButton = findViewById(R.id.nextButtonFull);
    }

    private void defineActions(){
        mPlayPauseButton.setOnClickListener(v -> {
            PlayAction.playPause();
        });
    }
}