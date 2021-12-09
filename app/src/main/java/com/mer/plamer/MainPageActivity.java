package com.mer.plamer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.usecases.PlayAction;

/**
 * Activity to construct the home page view
 */
public class MainPageActivity extends AppCompatActivity {

    /**
     * Construct view and define actions for each interactive elements
     * @param savedInstanceState savedInstanceState the previously saved state of this activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_layout);

        // set button
        ImageButton playing = findViewById(R.id.main_playing);
        ImageButton playButton = findViewById(R.id.main_play);
        ImageButton repeatButton = findViewById(R.id.main_repeat_list);
        ImageButton prevButton = findViewById(R.id.main_prev);
        ImageButton nextButton = findViewById(R.id.main_next);
        PlayerActivity.setButton(playButton, repeatButton);

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
            Intent intent = new Intent(MainPageActivity.this,
                    UniverseUserActivity.class);
            startActivity(intent);
        });

        // open the playing page
        playing.setOnClickListener(v -> {
            Intent intent = new Intent(MainPageActivity.this, PlayerActivity.class);
            startActivity(intent);
        });

        // play/pause music
        playButton.setOnClickListener(v -> {
            PlayControl.playPause();
            if (PlayAction.isPlaying()) {
                ((ImageButton) v).setImageResource(R.drawable.pause);
            } else {
                ((ImageButton) v).setImageResource(R.drawable.play);
            }
        });

        // change the loop style
        repeatButton.setOnClickListener(v -> {
            Toast.makeText(MainPageActivity.this,
                    PlayControl.changePlayMode(), Toast.LENGTH_SHORT).show();
            if (PlayAction.order == PlayAction.PlayOrder.LIST) {
                ((ImageButton) v).setImageResource(R.drawable.repeat_list);
            } else if (PlayAction.order == PlayAction.PlayOrder.REPEAT) {
                ((ImageButton) v).setImageResource(R.drawable.repeat_one);
            } else {
                ((ImageButton) v).setImageResource(R.drawable.random);
            }
        });

        // previous music
        prevButton.setOnClickListener(v -> PlayControl.prev());

        // next music
        nextButton.setOnClickListener(v -> PlayControl.next());
    }
}