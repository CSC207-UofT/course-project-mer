package com.mer.plamer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.TrackAdapter;
import com.mer.plamer.controller.UserControl;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.TrackLibraryAction;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist_layout);

        String username = getIntent().getStringExtra("curr_user");
        UserControl userControl = new UserControl();
        userControl.userAction.setUser(username);

        ImageButton back = findViewById(R.id.playlist_back_last_page);
        back.setOnClickListener(v -> finish());



        ImageButton playing = findViewById(R.id.playlist_playing);

        playing.setOnClickListener(v -> {
            Intent intent = new Intent(PlaylistActivity.this,
                    PlayerActivity.class);
            startActivity(intent);
        });


        ImageButton playButton = findViewById(R.id.playlist_play);
        playButton.setOnClickListener(v -> PlayControl.playPause());

        ImageButton repeatButton = findViewById(R.id.playlist_repeat_list);
        repeatButton.setOnClickListener(v -> PlayAction.loop());
    }
}