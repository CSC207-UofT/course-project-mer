package com.mer.plamer.entities;

import java.util.ArrayList;

/**
 * Library of playlists.
 */
public class PlaylistLibrary implements Storable<Playlist> {

    private final ArrayList<Playlist> playlists;

    /**
     * Constructor for PlaylistLibrary.
     */
    public PlaylistLibrary() {playlists = new ArrayList<>();}

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
     * @param id name of the playlist wanted to remove from
     * @return whether the playlist has been successfully removed.
     */
    @Override
    public boolean remove(String id) {
        if (this.contain(id) != null) {
            this.playlists.remove(this.contain(id));
            return true;
        } else {
            return false;
        }

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
     * @param id the name of the playlist we wanted to check
     * @return the playlist with name name.
     */
    @Override
    public Playlist contain(String id) {
        for (int i = 0; i < playlists.size(); i++) {
            if (playlists.get(i).getId().equals(id)) {
                return playlists.get(i);
            }
        }
        return null;
    }

}
