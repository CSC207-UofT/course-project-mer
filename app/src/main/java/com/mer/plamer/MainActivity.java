package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;


import com.mer.plamer.controller.*;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.TrackLibraryAction;


public class MainActivity extends AppCompatActivity {


    Button mOpenPlayerButton;
    Button mNextButtonSmall;
    Button mPreviousButtonSmall;
    Button mPlayPauseButtonSmall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TrackLibraryAction.scanLocal();
        PlayAction.prepare();

        setContentView(R.layout.activity_main);
        initializeViews();
        defineActions();

    }

    private void initializeViews(){
        mOpenPlayerButton = findViewById(R.id.openPlayerButton);
        mNextButtonSmall = findViewById(R.id.nextButtonSmall);
        mPreviousButtonSmall = findViewById(R.id.previousButtonSmall);
        mPlayPauseButtonSmall = findViewById(R.id.playPauseButtonSmall);
    }

    private void defineActions(){
        mOpenPlayerButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
            startActivity(intent);
        });

        mPlayPauseButtonSmall.setOnClickListener(v -> {
            PlayAction.playPause();
        });
    }


}