package com.mer.plamer.presenter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.R;
import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.PlaylistControl;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.UserLibraryAction;

import java.util.ArrayList;

/**
 * Activity to provide the view of a user's playlists
 */
public class UserPlaylistActivity extends AppCompatActivity {

    private ArrayList<String> playListID;

    /**
     * Construct view and define actions for each interactive elements
     * @param savedInstanceState savedInstanceState the previously saved state of this activity
     */
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist_layout);

        // set button
        ImageButton playing = findViewById(R.id.playlist_playing);
        ImageButton playButton = findViewById(R.id.playlist_play);
        ImageButton repeatButton = findViewById(R.id.playlist_repeat_list);
        ImageButton prevButton = findViewById(R.id.playlist_prev);
        ImageButton nextButton = findViewById(R.id.playlist_next);
        PlayerActivity.setButton(playButton, repeatButton);

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
            Intent intent = new Intent(UserPlaylistActivity.this,
                    OwnPlaylistActivity.class);
            intent.putExtra("play_list_id", id);
            startActivity(intent);
        };

        lv.setOnItemClickListener(openList);


        // back to the last page
        ImageButton back = findViewById(R.id.playlist_back_last_page);
        back.setOnClickListener(v -> finish());

        // create new playlist by pressing "+"
        @SuppressLint("InflateParams")
        View pop = getLayoutInflater().inflate(R.layout.new_playlist_popup_layout, null);

        // set the pop up window
        PopupWindow popupwindow = new PopupWindow(pop, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        ImageButton add = findViewById(R.id.playlist_add);
        ImageButton new_go = pop.findViewById(R.id.new_playlist_go);

        // show pop up window when click "+"
        add.setOnClickListener(v -> {
            popupwindow.showAsDropDown(add);
            // get the input of name
            EditText playlist_name = pop.findViewById(R.id.new_playlist_name);
            // confirm the name
            new_go.setOnClickListener(v1 -> {
                // add new playlist into library
                String pll_name = playlist_name.getText().toString();
                PlaylistControl playlistControl = new PlaylistControl();
                playlistControl.add(pll_name);
                ArrayList<String> lst = PlaylistLibraryAction.getListOfPlaylistId();
                int i = PlaylistLibraryAction.getListOfPlaylistId().size() - 1;
                playListID.add(lst.get(i));
                universalAdapter.notifyDataSetChanged();
                Toast.makeText(UserPlaylistActivity.this,
                        "You have created a playlist.", Toast.LENGTH_LONG).show();
                playlist_name.setText("");
                popupwindow.dismiss();
            });

        });

        // open the playing page
        playing.setOnClickListener(v -> {
            Intent intent = new Intent(UserPlaylistActivity.this, PlayerActivity.class);
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
            Toast.makeText(UserPlaylistActivity.this,
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