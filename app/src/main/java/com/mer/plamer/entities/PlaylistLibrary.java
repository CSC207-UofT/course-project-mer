package com.mer.plamer.entities;

import java.util.ArrayList;

/**
 * Library of playlists.
 */
public class PlaylistLibrary implements Storable<Playlist> {

    private ArrayList<Playlist> playlists;

    /**
     * Constructor for PlaylistLibrary.
     */
    public PlaylistLibrary() {}

    /**
     * Add playlist to this playlist library.
     * @param playlist the playlist we wanted to add to.
     */
    @Override
    public void add(Playlist playlist) {
        this.playlists.add(playlist);
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public boolean remove(String name) {
        for (Playlist p : this.playlists) {
            if (p.getName().equals(name)) {
                this.playlists.remove(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.playlists.size() == 0;
    }

    @Override
    public Playlist contain(String name) {
        for (Playlist p : this.playlists) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

}
