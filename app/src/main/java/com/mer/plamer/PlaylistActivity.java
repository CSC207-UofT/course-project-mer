package com.mer.plamer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.PlaylistAdapter;
import com.mer.plamer.controller.PlaylistControl;
import com.mer.plamer.controller.TrackAdapter;
import com.mer.plamer.controller.UserControl;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.TrackLibraryAction;
import com.mer.plamer.usecases.UserAction;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist_layout);

        String username = getIntent().getStringExtra("curr_user");
        UserControl userControl = new UserControl();
        userControl.userAction.setUser(username);

        PlaylistControl playlistControl = new PlaylistControl();

        // back to the last page
        ImageButton back = findViewById(R.id.playlist_back_last_page);
        back.setOnClickListener(v -> finish());

        // create new playlist by pressing "+"
        View pop = getLayoutInflater().inflate(R.layout.new_playlist_popup_layout, null);

        // show the pop up window
        PopupWindow popupwindow = new PopupWindow(pop, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        ImageButton add = findViewById(R.id.playlist_add);
        ImageButton new_go = pop.findViewById(R.id.new_playlist_go);


        add.setOnClickListener(v -> {


            popupwindow.showAsDropDown(add);
            EditText playlist_name = pop.findViewById(R.id.new_playlist_name);
            // confirm the name

            new_go.setOnClickListener(v1 -> {
                // the input of name

                // add new playlist into library
                String pll_name = playlist_name.getText().toString();
                if (userControl.createPlaylist(pll_name)){
                    Toast.makeText(PlaylistActivity.this,
                            "You have created a playlist.", Toast.LENGTH_LONG).show();
                    popupwindow.dismiss();
                } else {
                    Toast.makeText(PlaylistActivity.this,
                            "You didn't input the name of your playlist.", Toast.LENGTH_LONG).show();
                }
            });

        });

        // show the list of all playlists
        ArrayList<String> playListID = PlaylistLibraryAction.getListOfPlaylistId();
        ListView play_list_view;
        play_list_view = findViewById(R.id.playlist_list);
        play_list_view.setAdapter(new PlaylistAdapter(getApplicationContext(), playListID));

        // click playlist to open it
        play_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String id = playListID.get(i);
                Intent intent = new Intent(PlaylistActivity.this, OwnPlaylistActivity.class);
                intent.putExtra("play_list_id", id);
                startActivity(intent);
            }
        });

        // delete the playlist
        play_list_view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PlaylistActivity.this);
                builder.setMessage("Do you want to delete this playlist?");
                String list_id = playListID.get(position);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        playlistControl.remove(list_id);
                        Toast.makeText(PlaylistActivity.this,
                                "You have deleted a playlist.", Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.create().show();
                return false;
            }
        });

        // play music
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