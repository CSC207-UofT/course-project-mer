package com.mer.plamer.entities;
import java.util.ArrayList;

public class Playlist {
    private String name;
    private final ArrayList<Track> tracks;

    public Playlist(String name){
        this.name = name;
        this.tracks = new ArrayList<Track>();
    }

    public int getLength(){
        return this.tracks.size();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addTrack(Track item){
        this.tracks.add(item);
    }
}
