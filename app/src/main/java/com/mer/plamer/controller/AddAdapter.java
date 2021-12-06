package com.mer.plamer.controller;

        import android.annotation.SuppressLint;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.CheckBox;
        import android.widget.TextView;

        import com.mer.plamer.R;
        import com.mer.plamer.usecases.TrackLibraryAction;

        import java.util.ArrayList;
        import java.util.HashMap;

public class AddAdapter extends BaseAdapter {

    private ArrayList<String> trackID;
    private static HashMap<Integer, Boolean> isSelected;
    private Context context;
    private LayoutInflater inflater = null;

    private Boolean isShow = false;

    public AddAdapter(ArrayList<String> trackID, Context context, Boolean isShow){
        this.context = context;
        this.trackID = trackID;
        inflater = LayoutInflater.from(context);
        isSelected = new HashMap<Integer, Boolean>();
        this.isShow = isShow;

        initData();
    }

    private void initData() {
        for(int i = 0; i < trackID.size(); i++){
            getIsSelected().put(i, false);
        }
    }

    @Override
    public int getCount() {
        return trackID.size();
    }

    @Override
    public Object getItem(int position) {
        return trackID.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        String id = trackID.get(position);
        ArrayList<String> information = TrackLibraryAction.fetchMetadata(id);
        int length = Integer.parseInt(information.get(2));
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.add_item,null);
            holder = new ViewHolder();
            if (isShow) {
                holder.cb.setVisibility(View.VISIBLE);
            } else {
                holder.cb.setVisibility(View.GONE);
            }
            holder.trackTittle = convertView.findViewById(R.id.add_item_name);
            holder.trackArtist = convertView.findViewById(R.id.add_item_artist);
            holder.trackLength = convertView.findViewById(R.id.add_item_length);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.trackTittle.setText(information.get(0));
        holder.trackArtist.setText(information.get(1));
        holder.trackLength.setText(PlayControl.toMinuteSeconds(length));
        return convertView;
    }

    public static HashMap<Integer, Boolean> getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {
        AddAdapter.isSelected = isSelected;
    }

    public static class ViewHolder{
        public TextView trackTittle;
        public TextView trackArtist;
        public TextView trackLength;
        public CheckBox cb;
    }
}
