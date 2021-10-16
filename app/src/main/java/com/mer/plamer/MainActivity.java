package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import com.mer.plamer.controller.*;


public class MainActivity extends AppCompatActivity {

    public static final int EXAMPLE_MEDIA_ID = R.raw.oyasumi;

    private MediaPlyayerHolder
    ImageButton playButton;
    Button pauseButton;
    SeekBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void view(){
        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        progressBar = findViewById(R.id.seekBar);

        playButton.setOnClickListener(v -> {
            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), EXAMPLE_MEDIA_ID);
            mediaPlayer.start();
        });
        pauseButton.setOnClickListener(v -> {
            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), EXAMPLE_MEDIA_ID);
            mediaPlayer.start();
        });


    }

    void play(){
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), EXAMPLE_MEDIA_ID);
        mediaPlayer.start();
    }

    void pause(){

    }

}