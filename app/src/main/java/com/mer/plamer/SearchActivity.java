package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.PlaylistAdapter;
import com.mer.plamer.controller.SearchControl;
import com.mer.plamer.controller.TrackAdapter;
import com.mer.plamer.controller.UserAdapter;
import com.mer.plamer.usecases.PlayAction;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);

        result = "Track";
        Spinner spinner = findViewById(R.id.search_type);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                result = parent.getItemAtPosition(position).toString();
                Toast.makeText(SearchActivity.this, "You have selected "+
                        result + " to search.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // press search button to start search
        ImageButton go = findViewById(R.id.search_confirm);
        go.setOnClickListener(v -> {
            EditText in = findViewById(R.id.search_input);
            String search = in.getText().toString();
            toSearch(result,search);
        });

        // back to the last page
        ImageButton back = findViewById(R.id.search_back_last_page);
        back.setOnClickListener(v -> finish());

    }

    private void toSearch(String type, String input) {

        if (type.equals("Track")){
            ArrayList<TrackAdapter.TrackDataHolder> dataList = new ArrayList<>();
            ArrayList<String> lst = SearchControl.searchTrack(input);
            for (String id : lst){
                dataList.add(new TrackAdapter.TrackDataHolder(id));
            }
            // set adapter
            Toast.makeText(SearchActivity.this, input, Toast.LENGTH_SHORT).show();
            TrackAdapter adapter = new TrackAdapter(SearchActivity.this, dataList);
            ListView lv = findViewById(R.id.search_list);
            lv.setAdapter(adapter);

            // play the track when click
            lv.setOnItemClickListener((adapterView, view, i, l) -> {
                Toast.makeText(SearchActivity.this,
                        dataList.get(i).tittle +
                                " will be played.",Toast.LENGTH_SHORT).show();
                PlayControl.setMedia("NONE", dataList.get(i).id);
            });

        } else if (type.equals("Playlist")){
            ArrayList<String> lst;
            lst = SearchControl.searchPlaylist(input);
            // set adapter
            PlaylistAdapter adapter = new PlaylistAdapter(SearchActivity.this, lst);
            ListView lv = findViewById(R.id.search_list);
            lv.setAdapter(adapter);

            // open playlist when press
            ArrayList<String> finalLst = lst;
            AdapterView.OnItemClickListener openList = (parent, view, position, l) -> {
                String id = finalLst.get(position);
                Intent intent = new Intent(SearchActivity.this, OwnPlaylistActivity.class);
                intent.putExtra("play_list_id", id);
                startActivity(intent);
            };
            lv.setOnItemClickListener(openList);

        } else {
            ArrayList<String> lst;
            lst = SearchControl.searchUser(input);
            // set adapter
            UserAdapter adapter = new UserAdapter(SearchActivity.this, lst);
            ListView lv = findViewById(R.id.search_list);
            lv.setAdapter(adapter);
        }

        // open the playing page
        ImageButton playing = findViewById(R.id.search_playing);
        playing.setOnClickListener(v -> {
            Intent intent = new Intent(SearchActivity.this, PlayerActivity.class);
            startActivity(intent);
        });

        // play/pause music
        ImageButton playButton = findViewById(R.id.search_play);
        playButton.setOnClickListener(v -> PlayControl.playPause());

        // change the loop style
        ImageButton repeatButton = findViewById(R.id.search_repeat_list);
        repeatButton.setOnClickListener(v -> PlayAction.loop());
    }
}