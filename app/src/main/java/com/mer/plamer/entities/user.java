package com.mer.plamer.entities;

import java.util.ArrayList;

public class user {
    String username;
    String password;
    ArrayList<playlist> playlist;
    ArrayList<track> tracklist;

    public user(String name, String password){
        this.username = name;
        this.password = password;
        this.playlist = new ArrayList<playlist>();
        this.tracklist = new ArrayList<track>();
    }
}
