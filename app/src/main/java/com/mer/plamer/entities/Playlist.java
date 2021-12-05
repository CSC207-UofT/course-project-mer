package com.mer.plamer.entities;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * A playlist that can store tracks. Each playlist has a name and a playing status.
 * There are three valid status: REPEAT (repeat the playlist after finish),
 *                               RANDOM (play tracks randomly),
 *                               REPEAT_SINGLE (repeat a single track in the playlist)
 */
public class Playlist {

    private static final String[] validStatus = { "REPEAT", "RANDOM", "REPEAT_SINGLE" };
    private String name;
    private String status;
    private final ArrayList<Track> tracks;
    private final String playlist_id;
    private static int id = 0;

    /**
     * Constructor for Playlist. The initial status for the playlist is REPEAT.
     * @param name the name of the playlist.
     */
    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
        this.status = "REPEAT";
        this.playlist_id = String.valueOf(id);
        id ++;
    }

    /**
     * @return the number number of tracks in the playlist.
     */
    public int getLength() {
        return this.tracks.size();
    }

    /**
     * @return the name of the playlist.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the id of the playlist.
     */
    public String getId() { return this.playlist_id; }

    /**
     * @return the status of the playlist.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Change the status of the playlist.
     * @param status the status that the playlist wanted to change to.
     * @return whether status has been successfully changed or not.
     */
    public boolean setStatus(String status){
        for (String s : validStatus) {
            if (status.equals(s)) {
                this.status = status;
                return true;
            }
        }
        return false;
    }

    /**
     * Change the name of the playlist
     * @param name the name that the playlist wanted to change to.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Add new track to the playlist if the track is not already in the playlist.
     * @param track the track that we wanted to add to the playlist
     * @return whether the track has been successfully added
     */
    public boolean addTrack(Track track) {
        if (this.tracks.contains(track)) {
            return false;
        } else {
            this.tracks.add(track);
            return true;
        }
    }

    /**
     * Delete track from the playlist if the track is in the playlist.
     * @param track the track that we wanted to delete from the playlist
     * @return whether the track has been successfully deleted or not
     */
    public boolean delTrack(Track track) {
        if (this.tracks.contains(track)) {
            this.tracks.remove(track);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sort the playlist according to the comparator
     */
    public void sort(Comparator<Track> comparator) {
        this.tracks.sort(comparator);
    }

    /**
     * Get the tracks in this playlist
     * @return ArrayList<Track>
     */
    public ArrayList<Track> getTracks() {
        return this.tracks;
    }
}

