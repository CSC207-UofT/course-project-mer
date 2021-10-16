package com.mer.plamer.entities;

import java.util.ArrayList;

public class User {
    String username;
    String password;
    ArrayList<Playlist> playlist;
    ArrayList<Track> tracklist;

    public User(String name, String password){
        this.username = name;
        this.password = password;
        this.playlist = new ArrayList<Playlist>();
        this.tracklist = new ArrayList<Track>();
    }
}
