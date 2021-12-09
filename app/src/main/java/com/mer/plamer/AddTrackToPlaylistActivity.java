package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.mer.plamer.controller.AddAdapter;
import com.mer.plamer.controller.PlaylistControl;
import com.mer.plamer.usecases.PlaylistAction;
import com.mer.plamer.usecases.TrackLibraryAction;

import java.util.ArrayList;

/**
 * Activity to let user to add tracks to playlists and construct such view
 */
public class AddTrackToPlaylistActivity extends AppCompatActivity {

    private ArrayList<String> addedID;

    /**
     * Construct view and define actions for each interactive elements
     * @param savedInstanceState savedInstanceState the previously saved state of this activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_track_to_playlist_layout);

       // initialize data
        String pllID = getIntent().getStringExtra("play_list_id");
        final ArrayList<AddAdapter.AddDataHolder> dataList = new ArrayList<>();
        ArrayList<String> allTrack =  TrackLibraryAction.fetchAllTrackIDs();
        for (String id : allTrack){
            dataList.add(new AddAdapter.AddDataHolder(id, false));
        }
        addedID = new ArrayList<>();

        // create and set adapter
        final AddAdapter adapter = new AddAdapter(AddTrackToPlaylistActivity.this, dataList);
        final ListView lv = findViewById(R.id.add_list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((parent, view, position, id) -> {
            boolean checked = dataList.get(position).checked;
            if(!checked){
                dataList.get(position).checked = true;
                addedID.add(dataList.get(position).id);
            }else {
                dataList.get(position).checked = false;
                addedID.remove(dataList.get(position).id);
            }
            adapter.notifyDataSetChanged();
        });

        // back to the last page
        ImageButton back = findViewById(R.id.add_back_last_page);
        back.setOnClickListener(v -> finish());

        // confirm adding
        ImageButton go = findViewById(R.id.add_go);
        go.setOnClickListener(v -> {
            PlaylistAction pllA = new PlaylistAction();
            pllA.setPlaylist(pllID);
            PlaylistControl pllC = new PlaylistControl();
            pllC.setPlaylistAction(pllA);
            for (String id : addedID){
                pllC.trackAdd(id);
            }
            Toast.makeText(AddTrackToPlaylistActivity.this,
                    "You have added " + addedID.size() + " tracks.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(AddTrackToPlaylistActivity.this,
                    OwnPlaylistActivity.class);
            intent.putExtra("play_list_id", pllID);
            startActivity(intent);

        });

    }
}