package com.mer.plamer.entities;
import java.util.ArrayList;

public class Playlist {
    private String name;
    private final ArrayList<Track> tracks;

    public Playlist(String name){
        this.name = name;
        this.tracks = new ArrayList<>();
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

    public boolean addTrack(Track track) {
        if (this.tracks.contains(track)) {
            return false;
        } else {
            this.tracks.add(track);
            return true;
        }
    }
    public boolean delTrack(Track track) {
        if (this.tracks.contains(track)) {
            this.tracks.remove(track);
            return true;
        } else {
            return false;
        }
    }
}
