package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.mer.plamer.controller.TrackAdapter;
import com.mer.plamer.usecases.PlaylistAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.TrackLibraryAction;

import java.util.ArrayList;

public class OwnPlaylistActivity extends AppCompatActivity {

    private ArrayList<String> playListID;
    private ArrayList<String> playListName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.own_playlist_layout);

        String id = getIntent().getStringExtra("play_list_id");
        playListID = PlaylistLibraryAction.getListOfPlaylistId();
        playListName = PlaylistLibraryAction.getListOfPlaylistName();

        int index = playListID.indexOf(id);
        String name = playListName.get(index);


        // show the name of playlist
        TextView show_name = findViewById(R.id.own_playlist_name);
        show_name.setText(name);

        // back to the last page
        ImageButton back = findViewById(R.id.own_playlist_back_last_page);
        back.setOnClickListener(v -> finish());

        // show the list of all tracks
        ArrayList<String> own_playlist = PlaylistAction.getAllTrackId(id);
        ListView own_playlist_view;
        own_playlist_view = findViewById(R.id.own_playlist_track_list);
        own_playlist_view.setAdapter(new TrackAdapter(getApplicationContext(), own_playlist));

        // add new track
        ImageButton add = findViewById(R.id.own_playlist_add);
        add.setOnClickListener(v -> {
            Intent intent = new Intent(OwnPlaylistActivity.this, AddTrackToPlaylistActivity.class);
            intent.putExtra("play_list_id", id);
            startActivity(intent);
                });

    }
}