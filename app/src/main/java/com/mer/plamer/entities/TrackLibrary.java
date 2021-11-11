package com.mer.plamer.entities;

import java.util.ArrayList;

public class TrackLibrary implements Storable<Track> {
    private ArrayList<Track> tracksList;

    public TrackLibrary(){
    }

    @Override
    public void add(Track new_track) {

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
