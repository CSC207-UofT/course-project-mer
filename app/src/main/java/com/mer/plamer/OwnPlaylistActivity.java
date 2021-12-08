package com.mer.plamer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.PlaylistControl;
import com.mer.plamer.controller.TrackAdapter;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.PlaylistAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;

import java.util.ArrayList;

public class OwnPlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.own_playlist_layout);

        String pllID = getIntent().getStringExtra("play_list_id");
        PlaylistAction pllA = new PlaylistAction();
        pllA.setPlaylist(pllID);
        PlaylistControl pllC = new PlaylistControl();
        pllC.setPlaylistAction(pllA);
        ArrayList<String> playListID = PlaylistLibraryAction.getListOfPlaylistId();
        ArrayList<String> playListName = PlaylistLibraryAction.getListOfPlaylistName();

        int index = playListID.indexOf(pllID);
        String name = playListName.get(index);


        // show the name of playlist
        TextView show_name = findViewById(R.id.own_playlist_name);
        show_name.setText(name);

        // back to the last page
        ImageButton back = findViewById(R.id.own_playlist_back_to_main);
        back.setOnClickListener(v -> finish());

        // show the list of all tracks
        ArrayList<String> ownPlaylist = PlaylistAction.getAllTrackId(pllID);
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
            intent.putExtra("play_list_id", pllID);
            startActivity(intent);
            adapter.notifyDataSetChanged();
                });

        // play track when click on the track in the list
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(OwnPlaylistActivity.this,
                        dataList.get(i).tittle +
                                " will be played.",Toast.LENGTH_SHORT).show();
                PlayControl.setMedia(pllID, dataList.get(i).id);
            }
        });

        // delete a track
        AdapterView.OnItemLongClickListener deleteList = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(OwnPlaylistActivity.this);
                builder.setMessage("Do you want to delete this track?");
                String trackID = dataList.get(position).id;

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        pllC.trackRemove(trackID);
                        dataList.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(OwnPlaylistActivity.this,
                                "You have deleted a track.", Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();

                return true;
            }
        };
        lv.setOnItemLongClickListener(deleteList);

        // open the playing page
        ImageButton playing = findViewById(R.id.opll_playing);
        playing.setOnClickListener(v -> {
            Intent intent = new Intent(OwnPlaylistActivity.this, PlayerActivity.class);
            startActivity(intent);
        });

        // play/pause music
        ImageButton playButton = findViewById(R.id.opll_play);
        playButton.setOnClickListener(v ->{
            PlayControl.playPause();
            if (PlayAction.isPlaying()) {
                ((ImageButton)v).setImageResource(R.drawable.pause);
            } else{
                ((ImageButton) v).setImageResource(R.drawable.play);
            }
        });

        // change the loop style
        ImageButton repeatButton = findViewById(R.id.opll_repeat_list);
        repeatButton.setOnClickListener(v -> PlayAction.loop());

        // previous music
        ImageButton prevButton = findViewById(R.id.opll_prev);
        prevButton.setOnClickListener(v -> {
            PlayControl.prev();
        });

        // next music
        ImageButton nextButton = findViewById(R.id.opll_next);
        nextButton.setOnClickListener(v -> {
            PlayControl.next();
        });

    }
}