package com.mer.plamer.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mer.plamer.R;
import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    private final LayoutInflater testLayoutInflater;
    private final ArrayList<String> userList;
    private final ThreadLocal<Context> context = new ThreadLocal<>();

    public UserAdapter(Context testContext, ArrayList<String> userList){
        this.context.set(testContext);
        this.testLayoutInflater = LayoutInflater.from(testContext);
        this.userList = userList;
    }

    public UserAdapter(Context testContext, ArrayList<String> userList, LayoutInflater lif){
        this.context.set(testContext);
        this.testLayoutInflater = lif;
        this.userList = userList;
    }

    /**
     * Return the total number of items in a Listview.
     * @return an int of the number of items in a Listview
     */
    @Override
    public int getCount() {
        return userList.size();
    }

    /**
     * Return an item in a Listview that indicated by position.
     * @param position an int that indicate where an item is
     * @return an object which is indicated by the position
     */
    @Override
    public Object getItem(int position) {
        return userList.get(position);
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
        ViewHolder viewHolder;
        String name = userList.get(position);
        if (convertView == null) {
            convertView = testLayoutInflater.inflate(R.layout.universe_user_item,null);
            viewHolder = new ViewHolder();
            viewHolder.userName = convertView.findViewById(R.id.universe_user_username);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.userName.setText(name);
        return convertView;
    }

    /**
     * Hold views an item view need to show.
     */
    private static class ViewHolder{
        TextView userName;
    }
}
