package com.mer.plamer.entities;

import java.util.ArrayList;

public class TrackLibrary implements Storable<Track> {
    private final ArrayList<Track> tracksList;

    public TrackLibrary(){
        tracksList = new ArrayList<>();
    }

    @Override
    public void add(Track track) {
        tracksList.add(track);
    }
    
    public Track get(int Int){
        return tracksList.get(Int);
    }

    @Override
    public boolean remove(String name) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Track contain(String obj) {
        return null;
    }
}
