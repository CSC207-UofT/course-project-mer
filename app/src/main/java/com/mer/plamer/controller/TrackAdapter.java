package com.mer.plamer.controller;

import android.annotation.SuppressLint;
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

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<TrackDataHolder> lst;

    public TrackAdapter(Context context, ArrayList<TrackDataHolder> l){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.lst = l;
    }

    public TrackAdapter(Context context, LayoutInflater lif, ArrayList<TrackDataHolder> l) {
        this.context = context;
        this.inflater = lif;
        this.lst = l;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return lst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.track_item,null);
            holder = new ViewHolder();
            holder.trackTittle = convertView.findViewById(R.id.track_item_name);
            holder.trackArtist = convertView.findViewById(R.id.track_item_artist);
            holder.trackLength = convertView.findViewById(R.id.track_item_length);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.trackTittle.setText((String)lst.get(position).tittle);
        holder.trackArtist.setText((String)lst.get(position).artist);
        holder.trackLength.setText((String)lst.get(position).duration);
        return convertView;
    }

    private static class ViewHolder{
        TextView trackTittle;
        TextView trackArtist;
        TextView trackLength;
    }

    public static class TrackDataHolder {
        public String tittle;
        public String artist;
        public String duration;
        public String id;

        public TrackDataHolder(String i){
            ArrayList<String> info = TrackLibraryAction.fetchMetadata(i);
            id = i;
            tittle = info.get(0);
            artist = info.get(1);
            duration = PlayControl.toMinuteSeconds(Integer.parseInt(info.get(2)));
        }
    }
}
