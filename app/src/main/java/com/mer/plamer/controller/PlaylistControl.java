package com.mer.plamer.controller;

import com.mer.plamer.MyApp;
import com.mer.plamer.TinyDB;
import com.mer.plamer.usecases.PlaylistAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;

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
        boolean result = this.playlistAction.delTrack(track_id);
        tinydb.putObject("PlaylistLibrary", PlaylistLibraryAction.playlistLibrary);
        return result;
    }

    /**
     * Add a track from the playlist
     * @param track_id the track that we wanted to add to the playlist.
     * @return true if the track has been successfully removed.
     */
    public boolean trackAdd(String track_id) {
        boolean result = this.playlistAction.addTrack(track_id);
        tinydb.putObject("PlaylistLibrary", PlaylistLibraryAction.playlistLibrary);
        return result;
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

    /**
     * Create a new playlist.
     * @param name the name of the playlist.
     */
    public void add(String name) {
        PlaylistLibraryAction.add(name);
        tinydb.putInt("playlist_static_id", PlaylistLibraryAction.getStaticId());
        tinydb.putObject("PlaylistLibrary", PlaylistLibraryAction.playlistLibrary);
    }

    /**
     * Remove a playlist.
     * @param playlist_id the name of the playlist to remove.
     */
    public void remove(String playlist_id) {
        PlaylistLibraryAction.delete(playlist_id);
        tinydb.putObject("PlaylistLibrary", PlaylistLibraryAction.playlistLibrary);
    }

    /**
     * Scan and add the local playlists on every launch.
     */
    public void scanLocal() {
        if (tinydb.objectExists("PlaylistLibrary")) {
            PlaylistLibraryAction.assignLibrary(tinydb.getObject("PlaylistLibrary",
                    PlaylistLibraryAction.playlistLibrary.getClass()));
            PlaylistLibraryAction.changeId(tinydb.getInt("playlist_static_id"));
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
