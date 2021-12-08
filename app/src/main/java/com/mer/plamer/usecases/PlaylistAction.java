package com.mer.plamer.usecases;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.Track;

import java.util.ArrayList;
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
     * Create a new playlist.
     * @param name the name of the playlist.
     * @return the playlist that's been created.
     */
    public static Playlist createPlaylist(String name) {
        return new Playlist(name);
    }
    /**
     * Add new track to the playlist if the track is not already in the playlist.
     * @param track_id the track id that we wanted to add to the playlist
     * @return whether the track has been successfully added
     */
    public boolean addTrack(String track_id) {
        Track result = TrackLibraryAction.trackLibrary.get(track_id);
        if (result != null) {
            this.playlist.addTrack(result);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Delete track from the playlist if the track is in the playlist.
     * @param track_id the track id that we wanted to delete from the playlist
     * @return whether the track has been successfully deleted or not
     */
    public boolean delTrack(String track_id) {
        Track result = TrackLibraryAction.trackLibrary.get(track_id);
        if (result != null) {
            this.playlist.delTrack(result);
            return true;
        } else {
            return false;
        }
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

    /**
     * Sort the playlist randomly.
     */
    public void sortByRandom() {
        this.playlist.sort((o1, o2) -> {
            if (o1 == o2) return 0;
            Random rnd = ThreadLocalRandom.current();
            if (rnd.nextInt(2) == 0) return -1;
            return 1;
        });
    }

    /**
     * Set the status of Playlist if it is a valid status.
     * @param status The status that the playlist wanted to change to.
     */
    public void setStatus(String status) {
        this.playlist.setStatus(status);
    }

    /**
     * Get all track's id in an given playlist.
     * @param playlist_id the id of the playlist that we want.
     * @return all track's id in the playlist.
     */
    public static ArrayList<String> getAllTrackId(String playlist_id) {
        ArrayList<String> ids = new ArrayList<>();
        Playlist result = PlaylistLibraryAction.playlistLibrary.get(playlist_id);
        if (result != null) {
            ArrayList<Track> tracks = result.getTracks();
            for (Track track : tracks) {
                ids.add(track.getID());
            }
        }
        return ids;
    }
}
