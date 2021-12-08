package com.mer.plamer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.UniversalPlaylistAdapter;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.UserLibraryAction;

import java.util.ArrayList;

/**
 * Activity to provide the view of a user's playlists
 */
public class UserPlaylistActivity extends AppCompatActivity {

    private ArrayList<String> playListID;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist_layout);

        ImageButton add = findViewById(R.id.playlist_add);
        add.setImageResource(R.color.transparent);

        String name = getIntent().getStringExtra("selected_user_name");
        playListID = UserLibraryAction.getUserPlaylist(name);
        UniversalPlaylistAdapter universalAdapter = new
                UniversalPlaylistAdapter(UserPlaylistActivity.this, playListID);
        ListView lv = findViewById(R.id.playlist_list);

        // show tittle
        TextView tittle = findViewById(R.id.playlist_tittle);
        String t = name + "'s Playlists";
        tittle.setText(t);

        // show the list of all playlists
        lv.setAdapter(universalAdapter);

        // click playlist to open it
        AdapterView.OnItemClickListener openList = (parent, view, position, l) -> {
            String id = playListID.get(position);
            Intent intent = new Intent(UserPlaylistActivity.this, OwnPlaylistActivity.class);
            intent.putExtra("play_list_id", id);
            startActivity(intent);
        };

        lv.setOnItemClickListener(openList);


        // back to the last page
        ImageButton back = findViewById(R.id.playlist_back_last_page);
        back.setOnClickListener(v -> finish());

        // play music
        ImageButton playing = findViewById(R.id.playlist_playing);

        playing.setOnClickListener(v -> {
            Intent intent = new Intent(UserPlaylistActivity.this,
                    PlayerActivity.class);
            startActivity(intent);
        });

        // play/pause music
        ImageButton playButton = findViewById(R.id.playlist_play);
        playButton.setOnClickListener(v -> {
            PlayControl.playPause();
            if (PlayAction.isPlaying()) {
                ((ImageButton)v).setImageResource(R.drawable.pause);
            } else{
                ((ImageButton) v).setImageResource(R.drawable.play);
            }
        });

        // change the loop style
        ImageButton repeatButton = findViewById(R.id.playlist_repeat_list);
        repeatButton.setOnClickListener(v -> PlayAction.loop());

        // previous music
        ImageButton prevButton = findViewById(R.id.playlist_prev);
        prevButton.setOnClickListener(v -> PlayControl.prev());

        // next music
        ImageButton nextButton = findViewById(R.id.playlist_next);
        nextButton.setOnClickListener(v -> PlayControl.next());

    }


}