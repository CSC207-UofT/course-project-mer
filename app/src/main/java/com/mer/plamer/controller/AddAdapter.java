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

public class AddAdapter extends BaseAdapter {

    private ArrayList<AddDataHolder> lst;
    private Context context;
    private LayoutInflater inflater;

    public AddAdapter(Context context, ArrayList<AddDataHolder> l){
        this.context = context;
        this.lst = l;
        inflater = LayoutInflater.from(context);
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
        holder.trackTittle.setText((String)lst.get(position).tittle);
        holder.trackArtist.setText((String)lst.get(position).artist);
        holder.trackLength.setText((String)lst.get(position).duration);
        holder.cb.setChecked(lst.get(position).checked);
        return convertView;
    }

    public static class ViewHolder{
        TextView trackTittle;
        TextView trackArtist;
        TextView trackLength;
        CheckBox cb;
    }

    public static class AddDataHolder {
        public String tittle;
        public String artist;
        public String duration;
        public String id;
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
