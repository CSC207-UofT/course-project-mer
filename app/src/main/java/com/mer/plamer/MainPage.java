package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.mer.plamer.controller.PlayerActivity;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_layout);

        ImageButton main_setting = (ImageButton) findViewById(R.id.main_settings);
        main_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        ImageButton main_track = (ImageButton) findViewById(R.id.main_track_list);
        main_track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, TrackActivity.class);
                startActivity(intent);
            }
        });

        ImageButton main_playlist = (ImageButton) findViewById(R.id.main_playlist);
        main_playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, PlaylistActivity.class);
                startActivity(intent);
            }
        });

        ImageButton universe_users = (ImageButton) findViewById(R.id.main_users);
        universe_users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, UniverseUserActivity.class);
                startActivity(intent);
            }
        });

        ImageButton playing = (ImageButton) findViewById(R.id.main_playing);
        playing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, PlayerActivity.class);
                startActivity(intent);
            }
        });

    }
}