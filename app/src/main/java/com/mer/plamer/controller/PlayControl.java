package com.mer.plamer.controller;


import android.app.Activity;
import android.widget.ImageButton;
import android.widget.SeekBar;

import com.mer.plamer.R;
import com.mer.plamer.userAction.PlayAction;


public class PlayControl {
    PlayAction player;
    private final Activity ctx;
    ImageButton playButton;
    ImageButton pauseButton;
    SeekBar progressBar;

    // PlayControl takes in the activity context and audio file location
    public PlayControl(Activity ctx, int location) {
        this.ctx = ctx;
        this.player = new PlayAction(ctx.getResources().openRawResourceFd(location));
    }

    // Designate buttons to PlayControl view
    public void view(){
        playButton = ctx.findViewById(R.id.playButton);
        pauseButton = ctx.findViewById(R.id.pauseButton);
        progressBar = ctx.findViewById(R.id.seekBar);

        // When play button is clicked, tell PlayAction to play the audio
        playButton.setOnClickListener(v -> {
            player.play();
        });
        // When pause button is clicked, tell PlayAction to pause the audio
        pauseButton.setOnClickListener(v -> {
            player.pause();
        });
    }

    public void seek () {}

    public void playback () {}
}
