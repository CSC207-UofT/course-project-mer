package com.mer.plamer.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.mer.plamer.R;
import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.usecases.TrackLibraryAction;

import java.util.ArrayList;

/**
 * Adapter that convert data to Listview of add track into a playlist.
 */
public class AddAdapter extends BaseAdapter {

    private final ArrayList<AddDataHolder> lst;
    private final LayoutInflater inflater;
    private final ThreadLocal<Context> context = new ThreadLocal<>();

    public AddAdapter(Context context, ArrayList<AddDataHolder> l){
        this.context.set(context);
        this.lst = l;
        inflater = LayoutInflater.from(context);
    }

    public AddAdapter(Context context, ArrayList<AddDataHolder> l, LayoutInflater lif) {
        this.context.set(context);
        this.lst = l;
        this.inflater = lif;
    }

    /**
     * Return the total number of items in a Listview.
     * @return an int of the number of items in a Listview
     */
    @Override
    public int getCount() {
        return lst.size();
    }

    /**
     * Return an item in a Listview that indicated by position.
     * @param position an int that indicate where an item is
     * @return an object which is indicated by the position
     */
    @Override
    public Object getItem(int position) {
        return lst.get(position);
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
    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.add_item,null);
            holder.trackTittle = convertView.findViewById(R.id.add_item_name);
            holder.trackArtist = convertView.findViewById(R.id.add_item_artist);
            holder.trackLength = convertView.findViewById(R.id.add_item_length);
            holder.cb = convertView.findViewById(R.id.check_box);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.trackTittle.setText(lst.get(position).tittle);
        holder.trackArtist.setText(lst.get(position).artist);
        holder.trackLength.setText(lst.get(position).duration);
        holder.cb.setChecked(lst.get(position).checked);
        return convertView;
    }

    /**
     * Hold views an item view need to show.
     */
    public static class ViewHolder{
        TextView trackTittle;
        TextView trackArtist;
        TextView trackLength;
        CheckBox cb;
    }

    /**
     * Hold data input.
     */
    public static class AddDataHolder {
        public final String tittle;
        public final String artist;
        public final String duration;
        public final String id;
        public boolean checked;

        public AddDataHolder(String i, boolean c){
            ArrayList<String> info = TrackLibraryAction.fetchMetadata(i);
            id = i;
            tittle = info.get(0);
            artist = info.get(1);
            duration = PlayControl.toMinuteSeconds(Integer.parseInt(info.get(2)));
            checked = c;
        }
    }
}
