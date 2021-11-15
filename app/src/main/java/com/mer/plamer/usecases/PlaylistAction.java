package com.mer.plamer.usecases;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.Track;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Actions that a playlist can perform
 */
public class PlaylistAction {

    private final Playlist playlist;

    /**
     * Constructor for PlaylistAction.
     * @param playlist The playlist we want to perform action on.
     */
    public PlaylistAction(Playlist playlist) {
        this.playlist = playlist;
    }

    /**
     * Add new track to the playlist if the track is not already in the playlist.
     * @param track the track that we wanted to add to the playlist
     * @return whether the track has been successfully added
     */
    public boolean addTrack(Track track) {
        return this.playlist.addTrack(track);
    }

    /**
     * Delete track from the playlist if the track is in the playlist.
     * @param track the track that we wanted to delete from the playlist
     * @return whether the track has been successfully deleted or not
     */
    public boolean delTrack(Track track) {
        return this.playlist.delTrack(track);
    }

    /**
     * Sort the playlist by title.
     */
    public void sortByTitle() {
        this.playlist.sort(Comparator.comparing(Track::getTitle));
    }

    /**
     * Sort the playlist by artist.
     */
    public void sortByArtist() {
        this.playlist.sort(Comparator.comparing(Track::getArtist));
    }

    /**
     * Sort the playlist by length.
     */
    public void sortByLength() {
        this.playlist.sort(Comparator.comparing(Track::getLength));
    }

    // TODO: Reimplement sortByRandom to solve code warning
    /**
     * Sort the playlist randomly.
     */
    public void sortByRandom() {
        this.playlist.sort((o1, o2) -> {
            Random rnd = ThreadLocalRandom.current();
            if (rnd.nextInt(2) == 0) return -1;
            return 1;
        });
    }

    /**
     * Set the status of Playlist if it is a valid status.
     * @param status The status that the playlist wanted to change to.
     * @return whether the playlist has been successfully to this status.
     */
    public boolean setStatus(String status) {
        return this.playlist.setStatus(status);
    }
}
