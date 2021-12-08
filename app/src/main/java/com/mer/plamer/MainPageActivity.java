package com.mer.plamer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.usecases.PlayAction;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_layout);


        // open the setting page
        ImageButton setting = findViewById(R.id.main_settings);
        setting.setOnClickListener(v -> {
            Intent intent = new Intent(MainPageActivity.this, SettingActivity.class);
            startActivity(intent);
        });

        // open the track library
        ImageButton track = findViewById(R.id.main_track_list);
        track.setOnClickListener(v -> {
            Intent intent = new Intent(MainPageActivity.this, TrackActivity.class);
            startActivity(intent);
        });

        // open the playlist
        ImageButton playList = findViewById(R.id.main_playlist);
        playList.setOnClickListener(v -> {
            Intent intent = new Intent(MainPageActivity.this, PlaylistActivity.class);
            startActivity(intent);
        });

        // open the search page
        ImageButton search = findViewById(R.id.main_search);
        search.setOnClickListener(v -> {
            Intent intent = new Intent(MainPageActivity.this, SearchActivity.class);
            startActivity(intent);
        });

        // open the user library
        ImageButton users = findViewById(R.id.main_users);
        users.setOnClickListener(v -> {
            Intent intent = new Intent(MainPageActivity.this, UniverseUserActivity.class);
            startActivity(intent);
        });

        // open the playing page
        ImageButton playing = findViewById(R.id.main_playing);
        playing.setOnClickListener(v -> {
            Intent intent = new Intent(MainPageActivity.this, PlayerActivity.class);
            startActivity(intent);
        });

        // play/pause music
        ImageButton playButton = findViewById(R.id.main_play);
        playButton.setOnClickListener(v -> PlayControl.playPause());

        // change the loop style
        ImageButton repeatButton = findViewById(R.id.main_repeat_list);
        repeatButton.setOnClickListener(v -> PlayAction.loop());

        // previous music
        ImageButton prevButton = findViewById(R.id.main_prev);
        prevButton.setOnClickListener(v -> {
            // TODO
        });

        // next music
        ImageButton nextButton = findViewById(R.id.main_next);
        nextButton.setOnClickListener(v -> {
            // TODO
        });

    }
}