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
     * Remove playlist from this playlist library if the playlist is in this playlist library
     * @param name the name of the playlist wanted to remove from
     * @return whether the playlist has been successfully removed.
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

    /**
     * @return whether the playlist library is empty or not
     */
    @Override
    public boolean isEmpty() {
        return this.playlists.size() == 0;
    }

    /**
     * Check if the library contains certain playlist.
     * @param name the name of the playlist we wanted to check
     * @return the playlist with name name.
     */
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
