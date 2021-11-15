package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.mer.plamer.controller.PlayerActivity;
import com.mer.plamer.usecases.PlayAction;

public class TrackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_layout);

        ImageButton back = (ImageButton) findViewById(R.id.track_back_last_page);
        back.setOnClickListener(v -> finish());

        ImageButton playing = (ImageButton) findViewById(R.id.track_playing);
        playing.setOnClickListener(v -> {
            Intent intent = new Intent(TrackActivity.this, PlayerActivity.class);
            startActivity(intent);
        });

        ImageButton playButton = (ImageButton) findViewById(R.id.track_play);
        playButton.setOnClickListener(v -> PlayAction.playPause());

        ImageButton repeatButton = (ImageButton) findViewById(R.id.track_repeat_list);
        repeatButton.setOnClickListener(v -> PlayAction.loop());
    }
}