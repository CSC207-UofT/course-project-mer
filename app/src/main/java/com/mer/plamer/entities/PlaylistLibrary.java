package com.mer.plamer.entities;

import java.util.ArrayList;

import com.mer.plamer.TinyDB;
import com.mer.plamer.MyApp;

/**
 * Library of playlists.
 */
public class PlaylistLibrary implements Storable<Playlist> {

    private final ArrayList<Playlist> playlists;
    private final TinyDB tinydb = new TinyDB(MyApp.getContext());

    /**
     * Constructor for PlaylistLibrary.
     */
    public PlaylistLibrary() { playlists = new ArrayList<>(); }

    /**
     * Add playlist to this playlist library.
     * @param playlist the playlist we wanted to add to.
     */
    @Override
    public void add(Playlist playlist) {
        this.playlists.add(playlist);
    }

    /**
     * Create a new playlist of the name name.
     * @param name the name of the playlist.
     * @return the created playlist.
     */
    public Playlist create(String name) {
        return new Playlist(name);
    }

    /**
     * Remove playlist from this playlist library if the playlist is in this playlist library
     * @param id name of the playlist wanted to remove from
     * @return whether the playlist has been successfully removed.
     */
    @Override
    public boolean remove(String id) {
        if (this.get(id) != null) {
            this.playlists.remove(this.get(id));
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
    public Playlist get(String id) {
        for (int i = 0; i < playlists.size(); i++) {
            if (playlists.get(i).getId().equals(id)) {
                return playlists.get(i);
            }
        }
        return null;
    }

    /**
     * Get the playlists in the library
     * @return ArrayList<Playlist>
     */
    public ArrayList<Playlist> getPlaylists() {
        return this.playlists;
    }

    /**
     * Returns the playlist matching such input id, null if no such playlist exists
     * @param id the id of a playlist
     * @return the playlist matching such id
     */
    public Playlist getPlaylist(String id) {
        for(Playlist p:playlists){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    /**
     * Get a list of integers containing the size of every playlist.
     * @return the list of all playlist size.
     */
    public ArrayList<Integer> getListofPlaylistSize() {
        ArrayList<Integer> list_of_size = new ArrayList<Integer>();
        for (Playlist playlist : playlists) {
            list_of_size.add(playlist.getLength());
        }
        return list_of_size;
    }

    /**
     * Get a list of String containing the name of every playlist.
     * @return the list of all playlist name.
     */
    public ArrayList<String> getListofPlaylistName() {
        ArrayList<String> list_of_name = new ArrayList<String>();
        for (Playlist playlist : playlists) {
            list_of_name.add(playlist.getName());
        }
        return list_of_name;
    }

    /**
     * Get a list of String containing the id of every playlist.
     * @return the list of all playlist id.
     */
    public ArrayList<String> getListOfPlaylistId() {
        ArrayList<String> list_of_id = new ArrayList<String>();
        for (Playlist playlist : playlists) {
            list_of_id.add(playlist.getId());
        }
        return list_of_id;
    }

}
