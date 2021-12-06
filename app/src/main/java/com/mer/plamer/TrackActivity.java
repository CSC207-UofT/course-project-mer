package com.mer.plamer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.TrackAdapter;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.TrackLibraryAction;

import java.util.ArrayList;

public class TrackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_layout);


        ImageButton back = findViewById(R.id.track_back_last_page);
        back.setOnClickListener(v -> finish());

        ArrayList<String> track_id_list = TrackLibraryAction.fetchAllTrackIDs();
        ListView track_list_view;
        track_list_view = findViewById(R.id.track_list);
        track_list_view.setAdapter(new TrackAdapter(getApplicationContext(), track_id_list));
        track_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(TrackActivity.this,
                        TrackLibraryAction.fetchMetadata(track_id_list.get(i)).get(0) +
                                " will be played.",Toast.LENGTH_SHORT).show();
                PlayControl.setMedia("NONE", track_id_list.get(i));
            }
        });

        ImageButton playing = findViewById(R.id.track_playing);

        playing.setOnClickListener(v -> {
            Intent intent = new Intent(TrackActivity.this, PlayerActivity.class);
            startActivity(intent);
        });

        ImageButton playButton = findViewById(R.id.track_play);
        playButton.setOnClickListener(v -> PlayControl.playPause());

        ImageButton repeatButton = findViewById(R.id.track_repeat_list);
        repeatButton.setOnClickListener(v -> PlayAction.loop());
    }
}