package com.mer.plamer.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mer.plamer.R;
import com.mer.plamer.entities.User;
import com.mer.plamer.usecases.TrackLibraryAction;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    private Context testContext;
    private LayoutInflater testLayoutInflater;
    private ArrayList<String> userList;

    public UserAdapter(Context testContext, ArrayList<String> userList){
        this.testContext = testContext;
        this.testLayoutInflater = LayoutInflater.from(testContext);
        this.userList = userList;
    }

    public UserAdapter(Context testContext, ArrayList<String> userList, LayoutInflater lif){
        this.testContext = testContext;
        this.testLayoutInflater = lif;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
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

    private static class ViewHolder{
        TextView userName;
    }
}
