package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import com.mer.plamer.controller.*;


public class MainActivity extends AppCompatActivity {

    public static final int EXAMPLE_MEDIA_ID = R.raw.oyasumi;

    ImageButton playButton;
    ImageButton pauseButton;
    SeekBar progressBar;
    private PlayControl player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        player = new PlayControl(this);
        setContentView(R.layout.activity_main);

        // Load media
        player.load(EXAMPLE_MEDIA_ID);

        // Initialize button features
        view();
    }

    private void view(){
        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        progressBar = findViewById(R.id.seekBar);

        playButton.setOnClickListener(v -> {
            player.play();
        });
        pauseButton.setOnClickListener(v -> {
            player.pause();
        });


    }

}