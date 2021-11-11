package com.mer.plamer.entities;

import java.util.ArrayList;

public class TrackLibrary implements Storable<Track> {
    private final ArrayList<Track> tracksList;

    public TrackLibrary(){
        tracksList = new ArrayList<>();
    }

    public void add(Track track) {
        tracksList.add(track);
    }

    public Track get(int Int){
        return tracksList.get(Int);
    }

    public void remove() {
    }

    public void isEmpty() {
    }

    public void read() {
    }

    public void locate(){
        
    }
}
