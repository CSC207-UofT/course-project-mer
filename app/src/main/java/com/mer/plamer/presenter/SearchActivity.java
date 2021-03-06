package com.mer.plamer.presenter;

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

import com.mer.plamer.R;
import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.SearchControl;
import com.mer.plamer.usecases.PlayAction;

import java.util.ArrayList;

/**
 * Activity to provide the search page view and search features
 */
public class SearchActivity extends AppCompatActivity {

    private String result;


    /**
     * Construct view and define actions for each interactive elements
     * @param savedInstanceState savedInstanceState the previously saved state of this activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);

        // set button
        ImageButton playing = findViewById(R.id.search_playing);
        ImageButton playButton = findViewById(R.id.search_play);
        ImageButton repeatButton = findViewById(R.id.search_repeat_list);
        ImageButton prevButton = findViewById(R.id.search_prev);
        ImageButton nextButton = findViewById(R.id.search_next);
        PlayerActivity.setButton(playButton, repeatButton);

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

        // open the playing page
        playing.setOnClickListener(v -> {
            Intent intent = new Intent(SearchActivity.this, PlayerActivity.class);
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
            Toast.makeText(SearchActivity.this,
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
            UniversalPlaylistAdapter adapter =
                    new UniversalPlaylistAdapter(SearchActivity.this, lst);
            ListView lv = findViewById(R.id.search_list);
            lv.setAdapter(adapter);

            // open playlist when press
            ArrayList<String> finalLst = lst;
            AdapterView.OnItemClickListener openList = (parent, view, position, l) -> {
                String id = finalLst.get(position);
                Intent intent = new
                        Intent(SearchActivity.this, OwnPlaylistActivity.class);
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

            // open all the playlists this user has
            AdapterView.OnItemClickListener openList = (parent, view, position, l) -> {
                String username = lst.get(position);
                Intent intent = new
                        Intent(SearchActivity.this, UserPlaylistActivity.class);
                intent.putExtra("selected_user_name", username);
                startActivity(intent);
            };
            lv.setOnItemClickListener(openList);
        }
    }
}