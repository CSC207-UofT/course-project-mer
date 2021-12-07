package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.mer.plamer.controller.AddAdapter;
import com.mer.plamer.usecases.TrackLibraryAction;

import java.util.ArrayList;

public class AddTrackToPlaylistActivity extends AppCompatActivity {

    private ArrayList<String> addedID;

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
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                boolean checked = dataList.get(position).checked;
                if(!checked){
                    dataList.get(position).checked = true;
                    addedID.add(dataList.get(position).id);
                }else {
                    dataList.get(position).checked = false;
                    addedID.remove(dataList.get(position).id);
                }
                adapter.notifyDataSetChanged();
            }
        });

        // back to the last page
        ImageButton back = findViewById(R.id.add_back_last_page);
        back.setOnClickListener(v -> finish());

        // confirm adding
        ImageButton go = findViewById(R.id.add_go);
        go.setOnClickListener(v -> {
            for (String id : addedID){
                int i = 0;
            }
            Toast.makeText(AddTrackToPlaylistActivity.this,
                    "You have added " + addedID.size() + " tracks.", Toast.LENGTH_LONG).show();

        });

    }
}