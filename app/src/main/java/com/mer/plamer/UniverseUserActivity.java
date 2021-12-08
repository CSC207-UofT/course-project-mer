package com.mer.plamer;


import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.UserAdapter;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.UserLibraryAction;

import java.util.ArrayList;

public class UniverseUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universe_user_layout);

        // back to the last page
        ImageButton back = findViewById(R.id.universe_user_back_last_page);
        back.setOnClickListener(v -> finish());

        // set adapter
        ArrayList<String> nameList = UserLibraryAction.getAllUserName();
        ListView UserListView;
        UserListView = findViewById(R.id.universe_user_list);
        UserAdapter adapter = new UserAdapter(UniverseUserActivity.this, nameList);
        UserListView.setAdapter(adapter);

        // delete user
        AdapterView.OnItemLongClickListener deleteUser = (parent, view, position, id) -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(UniverseUserActivity.this);
            builder.setMessage("Do you want to delete this user?");

            builder.setPositiveButton("Yes", (dialog, which) -> {
                // TODO
                adapter.notifyDataSetChanged();
                Toast.makeText(UniverseUserActivity.this,
                        "You have deleted a playlist.", Toast.LENGTH_LONG).show();
            });

            builder.setNegativeButton("Cancel", (dialog, which) -> {

            });
            builder.create().show();

            return true;
        };

        UserListView.setOnItemLongClickListener(deleteUser);

        // open all the play list this user has
        AdapterView.OnItemClickListener openList = (parent, view, position, l) -> {
            String id = nameList.get(position);
            Intent intent = new Intent(UniverseUserActivity.this, UserPlaylistActivity.class);
            intent.putExtra("selected_user_name", id);
            startActivity(intent);
        };

        UserListView.setOnItemClickListener(openList);

        // open the playing page
        ImageButton playing = findViewById(R.id.universe_user_playing);
        playing.setOnClickListener(v -> {
            Intent intent = new Intent(UniverseUserActivity.this, PlayerActivity.class);
            startActivity(intent);
        });

        // play/pause music
        ImageButton playButton = findViewById(R.id.universe_user_play);
        playButton.setOnClickListener(v -> {
            PlayControl.playPause();
            if (PlayAction.isPlaying()) {
                ((ImageButton)v).setImageResource(R.drawable.pause);
            } else{
                ((ImageButton) v).setImageResource(R.drawable.play);
            }
        });

        // change the loop style
        ImageButton repeatButton = findViewById(R.id.universe_user_repeat_list);
        repeatButton.setOnClickListener(v -> PlayAction.loop());

        // previous music
        ImageButton prevButton = findViewById(R.id.universe_user_prev);
        prevButton.setOnClickListener(v -> {
            PlayControl.prev();
        });

        // next music
        ImageButton nextButton = findViewById(R.id.universe_user_next);
        nextButton.setOnClickListener(v -> {
            PlayControl.next();
        });
    }
}