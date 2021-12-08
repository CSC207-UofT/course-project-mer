package com.mer.plamer.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mer.plamer.R;
import com.mer.plamer.usecases.PlaylistLibraryAction;

import java.util.ArrayList;

public class PlaylistAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<String> playListID;
    private ArrayList<String> playListName;
    private ArrayList<Integer> playListSize;

    public PlaylistAdapter(Context context, ArrayList<String> playListID){
        this.inflater = LayoutInflater.from(context);
        this.playListID = playListID;
    }

    @Override
    public int getCount() {
        return playListID.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        UserControl userControl = new UserControl();
        String id = playListID.get(position);
        playListName = userControl.userAction.Playlistname();
        playListSize = userControl.userAction.Playlistsize();
        int i = userControl.userAction.getCurrentPlaylists().indexOf(id);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.playlist_item,null);
            viewHolder = new ViewHolder();
            viewHolder.playListName = convertView.findViewById(R.id.playlist_item_name);
            viewHolder.playListLength = convertView.findViewById(R.id.playlist_item_length);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.playListName.setText(playListName.get(i));
        viewHolder.playListLength.setText(playListSize.get(i).toString());
        return convertView;
    }

    private static class ViewHolder{
        TextView playListName;
        TextView playListLength;
    }
}
