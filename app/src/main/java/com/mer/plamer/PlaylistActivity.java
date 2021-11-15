package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.mer.plamer.controller.PlayerActivity;
import com.mer.plamer.usecases.PlayAction;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist_layout);

        ImageButton back = (ImageButton) findViewById(R.id.playlist_back_last_page);
        back.setOnClickListener(v -> finish());

        ImageButton playing = (ImageButton) findViewById(R.id.playlist_playing);
        playing.setOnClickListener(v -> {
            Intent intent = new Intent(PlaylistActivity.this,
                    PlayerActivity.class);
            startActivity(intent);
        });


        ImageButton playButton = (ImageButton) findViewById(R.id.playlist_play);
        playButton.setOnClickListener(v -> PlayAction.playPause());

        ImageButton repeatButton = (ImageButton) findViewById(R.id.playlist_repeat_list);
        repeatButton.setOnClickListener(v -> PlayAction.loop());
    }
}