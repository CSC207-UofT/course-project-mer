package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.TrackAdapter;
import com.mer.plamer.usecases.PlaylistAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;

import java.util.ArrayList;

public class OwnPlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.own_playlist_layout);

        String id = getIntent().getStringExtra("play_list_id");
        ArrayList<String> playListID = PlaylistLibraryAction.getListOfPlaylistId();
        ArrayList<String> playListName = PlaylistLibraryAction.getListOfPlaylistName();

        int index = playListID.indexOf(id);
        String name = playListName.get(index);


        // show the name of playlist
        TextView show_name = findViewById(R.id.own_playlist_name);
        show_name.setText(name);

        // back to the last page
        ImageButton back = findViewById(R.id.own_playlist_back_to_main);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(OwnPlaylistActivity.this, MainPageActivity.class);
            startActivity(intent);
        });

        // show the list of all tracks
        ArrayList<String> ownPlaylist = PlaylistAction.getAllTrackId(id);
        final ArrayList<TrackAdapter.TrackDataHolder> dataList = new ArrayList<>();
        for (String i : ownPlaylist){
            dataList.add(new TrackAdapter.TrackDataHolder(i));
        }
        ListView lv;
        final TrackAdapter adapter = new TrackAdapter(OwnPlaylistActivity.this, dataList);
        lv = findViewById(R.id.own_playlist_track_list);
        lv.setAdapter(adapter);

        // add new track
        ImageButton add = findViewById(R.id.own_playlist_add);
        add.setOnClickListener(v -> {
            Intent intent = new Intent(OwnPlaylistActivity.this, AddTrackToPlaylistActivity.class);
            intent.putExtra("play_list_id", id);
            startActivity(intent);
            adapter.notifyDataSetChanged();
                });

        // delete a track

        // play track when click on the track in the list
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(OwnPlaylistActivity.this,
                        dataList.get(i).tittle +
                                " will be played.",Toast.LENGTH_SHORT).show();
                PlayControl.setMedia("NONE", dataList.get(i).id);
            }
        });

    }
}