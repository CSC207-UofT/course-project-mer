package com.mer.plamer.controller;

import com.mer.plamer.entities.Track;
import com.mer.plamer.usecases.PlaylistAction;

/**
 * The controller class for playlist.
 */
public class PlaylistControl {
    PlaylistAction playlistAction;

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
     * @param track the track that we wanted to be removed from the playlist.
     * @return true if the track has been successfully removed.
     */
    public boolean trackRemove(Track track) {
        return this.playlistAction.delTrack(track);
    }

    /**
     * Add a track from the playlist
     * @param track the track that we wanted to add to the playlist.
     * @return true if the track has been successfully removed.
     */
    public boolean trackAdd(Track track) {
        return this.playlistAction.addTrack(track);
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
     * Set the status of the playlist to status.
     * @param status the status of the playlist that we want to set to.
     */
    public void setStatus(String status) {
        this.playlistAction.setStatus(status);
    }
}
