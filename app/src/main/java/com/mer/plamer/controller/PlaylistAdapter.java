package com.mer.plamer.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mer.plamer.R;

import java.util.ArrayList;

/**
 * Adapter that convert data to Listview of playlist.
 */
public class PlaylistAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final ArrayList<String> playListID;

    /**
     * Constructor for PlaylistAdapter
     * @param context the context
     * @param playListID the IDs of playlists fetching data from
     */
    public PlaylistAdapter(Context context, ArrayList<String> playListID){
        this.inflater = LayoutInflater.from(context);
        this.playListID = playListID;
    }

    /**
     * Alternative constructor for PlaylistAdapter
     * @param lif the layout inflator of selected xml file
     * @param playListID the IDs of playlists fetching data from
     */
    public PlaylistAdapter(LayoutInflater lif, ArrayList<String> playListID) {
        this.inflater = lif;
        this.playListID = playListID;
    }

    /**
     * Return the total number of items in a Listview.
     * @return an int of the number of items in a Listview
     */
    @Override
    public int getCount() {
        return playListID.size();
    }

    /**
     * Return an item in a Listview that indicated by position.
     * @param position an int that indicate where an item is
     * @return an object which is indicated by the position
     */
    @Override
    public Object getItem(int position) {
        return playListID.get(position);
    }

    /**
     * Return id of an item in a Listview that indicated by position.
     * @param position an int that indicate where an item is
     * @return an id of an item which is indicated by position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Display the view by converting data input.
     * @param position an int indicate where an item is
     * @param convertView an view that holds the old view of item
     * @param parent parent view
     * @return a view that holds the view created by this method
     */
    @SuppressLint({"InflateParams", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        UserControl userControl = new UserControl();
        String id = playListID.get(position);

        ArrayList<String> playListName = userControl.userAction.Playlistname();
        ArrayList<Integer> playListSize = userControl.userAction.Playlistsize();
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

    /**
     * Hold views an item view need to show.
     */
    private static class ViewHolder{
        TextView playListName;
        TextView playListLength;
    }
}
