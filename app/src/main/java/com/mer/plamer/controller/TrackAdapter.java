package com.mer.plamer.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mer.plamer.R;
import com.mer.plamer.usecases.TrackLibraryAction;

import java.util.ArrayList;

public class TrackAdapter extends BaseAdapter {

    private Context testContext;
    private LayoutInflater testLayoutInflater;
    private ArrayList<String> trackListID;

    public TrackAdapter(Context testContext, ArrayList<String> trackListID){
        this.testContext = testContext;
        this.testLayoutInflater = LayoutInflater.from(testContext);
        this.trackListID = trackListID;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        String id = trackListID.get(position);
        ArrayList<String> information = TrackLibraryAction.fetchMetadata(id);
        if (convertView == null) {
            convertView = testLayoutInflater.inflate(R.layout.track_item,null);
            viewHolder = new ViewHolder();
            viewHolder.trackTittle = convertView.findViewById(R.id.track_item_name);
            viewHolder.trackArtist = convertView.findViewById(R.id.track_item_artist);
            viewHolder.trackLength = convertView.findViewById(R.id.track_item_length);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.trackTittle.setText(information.get(0));
        viewHolder.trackArtist.setText(information.get(1));
        viewHolder.trackLength.setText(information.get(2));
        return convertView;
    }

    private static class ViewHolder{
        TextView trackTittle;
        TextView trackArtist;
        TextView trackLength;
    }
}
