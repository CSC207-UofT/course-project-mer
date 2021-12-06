package com.mer.plamer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;

import com.mer.plamer.controller.AddAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class AddTrackToPlaylistActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ListView listView;
    private ImageButton go;
    private ArrayList<String> trackID;
    private AddAdapter adapter;
    private CheckBox checkBox;
    private int checkNum;
    private ArrayList<String> list;
    private Boolean isShow = false;

    private void show() {
        adapter = new AddAdapter(trackID, getApplicationContext(), true);
        listView.setAdapter(adapter);
        isShow = true;
    }
    private void dismiss() {
        adapter = new AddAdapter(trackID, getApplicationContext(), false);
        listView.setAdapter(adapter);
        isShow = false;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_track_to_playlist_layout);
        initView();
        adapter = new AddAdapter(trackID, getApplicationContext(), false);
        isShow = false;
        listView.setAdapter(adapter);
    }

    public void initView() {
        View view = LayoutInflater.from(this).inflate(R.layout.add_item, null);
        checkBox = (CheckBox) view.findViewById(R.id.check_box);
        listView = (ListView) findViewById(R.id.add_list);
        go = (ImageButton) findViewById(R.id.add_go);
        list = new ArrayList<String>();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AddAdapter.ViewHolder holder = (AddAdapter.ViewHolder) view.getTag();
        holder.cb.toggle();
        AddAdapter.getIsSelected().put(position, holder.cb.isChecked());
    }

    @Override
    public void onClick(View v) {
        String id = getIntent().getStringExtra("play_list_id");
        HashMap<Integer, Boolean> map = AddAdapter.getIsSelected();
        Set setID = map.keySet();
        ArrayList<String> idList = new ArrayList<>();
        for (Object str: setID) {
            if (map.get(str)) {
                idList.add((String) str);
            }
        }

    }
}