package com.mer.plamer.entities;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Playlist> playlist;
    private ArrayList<Track> uploadedTracks;

    public User(String name, String password){
        this.username = name;
        this.password = password;
        this.playlist = new ArrayList<Playlist>();
        this.uploadedTracks = new ArrayList<Track>();
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
