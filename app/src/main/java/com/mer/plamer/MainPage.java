package com.mer.plamer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.UserControl;
import com.mer.plamer.usecases.PlayAction;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_layout);

        String username = getIntent().getStringExtra("curr_user");

        ImageButton main_setting = findViewById(R.id.main_settings);
        main_setting.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage.this, SettingActivity.class);
            intent.putExtra("curr_user", username);
            startActivity(intent);
        });

        ImageButton main_track = findViewById(R.id.main_track_list);
        main_track.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage.this, TrackActivity.class);
            startActivity(intent);
        });

        ImageButton main_playlist = findViewById(R.id.main_playlist);
        main_playlist.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage.this, PlaylistActivity.class);
            intent.putExtra("curr_user", username);
            startActivity(intent);
        });

        ImageButton universe_users = findViewById(R.id.main_users);
        universe_users.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage.this, UniverseUserActivity.class);
            intent.putExtra("curr_user", username);
            startActivity(intent);
        });

        ImageButton playing = findViewById(R.id.main_playing);

        playing.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage.this, PlayerActivity.class);
            startActivity(intent);
        });

        ImageButton playButton = findViewById(R.id.main_play);
        playButton.setOnClickListener(v -> PlayControl.playPause());

        ImageButton repeatButton = findViewById(R.id.main_repeat_list);
        repeatButton.setOnClickListener(v -> PlayAction.loop());

    }
}