package com.mer.plamer.entities;
import java.util.ArrayList;

public class Playlist {
    String name;
    ArrayList<Track> playlist;
    int length;

    public Playlist(String name){
        this.name = name;
        this.playlist = new ArrayList<Track>();
        this.length = 0;
    }

    public void updateLength(){
        this.length = this.playlist.size();
    }
}
