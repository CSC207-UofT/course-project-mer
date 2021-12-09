package com.mer.plamer.presenter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mer.plamer.R;
import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.PlaylistControl;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.PlaylistAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;

import java.util.ArrayList;

/**
 * Activity to provide the view of a playlist, and to associate playing, adding/removing media
 */
public class OwnPlaylistActivity extends AppCompatActivity {

    /**
     * Construct view and define actions for each interactive elements
     * @param savedInstanceState savedInstanceState the previously saved state of this activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.own_playlist_layout);

        // set button
        ImageButton playing = findViewById(R.id.opll_playing);
        ImageButton playButton = findViewById(R.id.opll_play);
        ImageButton repeatButton = findViewById(R.id.opll_repeat_list);
        ImageButton prevButton = findViewById(R.id.opll_prev);
        ImageButton nextButton = findViewById(R.id.opll_next);
        PlayerActivity.setButton(playButton, repeatButton);

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
            Intent intent = new Intent(OwnPlaylistActivity.this,
                    AddTrackToPlaylistActivity.class);
            intent.putExtra("play_list_id", pllID);
            startActivity(intent);
            adapter.notifyDataSetChanged();
                });

        // play track when click on the track in the list
        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(OwnPlaylistActivity.this,
                    dataList.get(i).tittle +
                            " will be played.",Toast.LENGTH_SHORT).show();
            PlayControl.setMedia(pllID, dataList.get(i).id);
        });

        // delete a track
        AdapterView.OnItemLongClickListener deleteList = (parent, view, position, id) -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(OwnPlaylistActivity.this);
            builder.setMessage("Do you want to delete this track?");
            String trackID = dataList.get(position).id;

            builder.setPositiveButton("Yes", (dialog, which) -> {
                pllC.trackRemove(trackID);
                dataList.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(OwnPlaylistActivity.this,
                        "You have deleted a track.", Toast.LENGTH_LONG).show();
            });

            builder.setNegativeButton("Cancel", (dialog, which) -> {

            });
            builder.create().show();

            return true;
        };
        lv.setOnItemLongClickListener(deleteList);

        // open the playing page
        playing.setOnClickListener(v -> {
            Intent intent = new Intent(OwnPlaylistActivity.this, PlayerActivity.class);
            startActivity(intent);
        });

        // play/pause music
        playButton.setOnClickListener(v -> {
            PlayControl.playPause();
            if (PlayAction.isPlaying()) {
                ((ImageButton)v).setImageResource(R.drawable.pause);
            } else{
                ((ImageButton) v).setImageResource(R.drawable.play);
            }
        });

        // change the loop style
        repeatButton.setOnClickListener(v -> {
            Toast.makeText(OwnPlaylistActivity.this,
                    PlayControl.changePlayMode(), Toast.LENGTH_SHORT).show();
            if (PlayAction.order == PlayAction.PlayOrder.LIST){
                ((ImageButton)v).setImageResource(R.drawable.repeat_list);
            }
            else if(PlayAction.order == PlayAction.PlayOrder.REPEAT){
                ((ImageButton)v).setImageResource(R.drawable.repeat_one);
            }
            else{
                ((ImageButton)v).setImageResource(R.drawable.random);
            }
        });

        // previous music
        prevButton.setOnClickListener(v -> PlayControl.prev());

        // next music
        nextButton.setOnClickListener(v -> PlayControl.next());

    }
}