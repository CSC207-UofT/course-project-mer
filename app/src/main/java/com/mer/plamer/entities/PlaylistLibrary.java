package com.mer.plamer.entities;

import java.util.ArrayList;

public class PlaylistLibrary implements Storable<Playlist> {
    private ArrayList<Playlist> playlistList;

    public PlaylistLibrary(){
    }

    @Override
    public void add(Playlist new_playlist) {
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
    public Playlist contain(String obj) {
        return null;
    }

}
