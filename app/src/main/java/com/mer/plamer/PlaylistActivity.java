package com.mer.plamer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;

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

        // back to the last page
        ImageButton back = findViewById(R.id.playlist_back_last_page);
        back.setOnClickListener(v -> finish());

        // create new playlist by pressing "+"
        ImageButton add = findViewById(R.id.playlist_add);
        add.setOnClickListener(v -> {
            View pop = getLayoutInflater().inflate(R.layout.new_playlist_popup_layout, null);

            // show the pop up window
            PopupWindow popupwindow = new PopupWindow(pop, ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, true);
            popupwindow.showAsDropDown(add);

            // confirm the name
            ImageButton new_go = pop.findViewById(R.id.new_playlist_go);
            new_go.setOnClickListener(v1 -> {
                // add new playlist into library
                // back to the last page
                popupwindow.dismiss();
            });

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