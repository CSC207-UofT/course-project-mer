
package com.mer.plamer.controller;

import com.mer.plamer.MyApp;
import com.mer.plamer.TinyDB;
import com.mer.plamer.usecases.PlaylistAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.UserLibraryAction;

/**
 * The controller class for playlist.
 */
public class PlaylistControl {
    PlaylistAction playlistAction;
    TinyDB tinydb = new TinyDB(MyApp.getContext());

    /**
     * Constructor for Playlist Control, initially playlistAction is null.
     */
    public PlaylistControl() {
        this.playlistAction = null;
    }

    /**
     * Create a new playlist.
     * @param playlist_name the name of the playlist.
     */
    public void createAddPlaylist(String playlist_name) {
        PlaylistLibraryAction.playlistLibrary.add(PlaylistAction.createPlaylist(playlist_name));
    }

    /**
     * Set playlist action to plAction.
     * @param plAction the playlist action that we wanted to set playlistAction to.
     */
    public void setPlaylistAction(PlaylistAction plAction) {
        this.playlistAction = plAction;
    }

    /**
     * Remove a track from playlist.
     * @param track_id the track id that we wanted to be removed from the playlist.
     * @return true if the track has been successfully removed.
     */
    public boolean trackRemove(String track_id) {
        return this.playlistAction.delTrack(track_id);
    }

    /**
     * Add a track from the playlist
     * @param track_id the track id that we wanted to add to the playlist.
     * @return true if the track has been successfully removed.
     */
    public boolean trackAdd(String track_id) {
        return this.playlistAction.addTrack(track_id);
    }

    /**
     * Sort the track in a specific way.
     * @param SortBy the way that we want to sort the playlist.
     * @return true if the playlist is sorted successfully.
     */
    public boolean sort(String SortBy) {
        switch (SortBy) {
            case "Title":
                this.playlistAction.sortByTitle();
                return true;
            case "Artist":
                this.playlistAction.sortByArtist();
                return true;
            case "Length":
                this.playlistAction.sortByLength();
                return true;
            case "Random":
                this.playlistAction.sortByRandom();
                return true;
            default:
                return false;
        }
    }

    public void add(String name) {
        PlaylistLibraryAction.add(name);
        tinydb.putObject("PlaylistLibrary", PlaylistLibraryAction.playlistLibrary);
    }

    public void remove(String name) {
        PlaylistLibraryAction.delete(name);
        tinydb.putObject("PlaylistLibrary", PlaylistLibraryAction.playlistLibrary);
    }

    /**
     * Scan and add the local playlists on every launch.
     */
    public void scanLocal() {
        if (tinydb.objectExists("PlaylistLibrary")) {
            PlaylistLibraryAction.assignLibrary(tinydb.getObject("PlaylistLibrary",
                    PlaylistLibraryAction.playlistLibrary.getClass()));
        }
    }

    /**
     * Set the status of the playlist to status.
     * @param status the status of the playlist that we want to set to.
     */
    public void setStatus(String status) {
        this.playlistAction.setStatus(status);
    }
}
