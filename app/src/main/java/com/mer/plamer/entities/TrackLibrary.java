package com.mer.plamer.entities;

import com.mer.plamer.MyApp;
import com.mer.plamer.TinyDB;

import java.util.ArrayList;
import java.util.List;

public class TrackLibrary implements Storable<Track> {
    private final ArrayList<Track> tracksList;
    private final TinyDB tinydb = new TinyDB(MyApp.getContext());

    /**
     * Constructor for TrackLibrary.
     */
    public TrackLibrary() {
        tracksList = new ArrayList<>();
    }

    /**
     * Add Track to this track library.
     * @param track the track we wanted to add to.
     */
    @Override
    public void add(Track track) {
        tinydb.putObject(track.getId() + "t", track);
        tracksList.add(track);
    }

    /**
     * create a new track.
     * @param path the path of the track.
     * @return the created track.
     */
    public Track create(String path) {
        Track new_track = new Track(path);
        tinydb.putInt("track_static_id", Integer.parseInt(new_track.getId()));
        return new_track;
    }

    /**
     * Get the track at index Int.
     * @param Int the index of the track we want to get.
     * @return the track at the index.
     */
    public Track get(int Int) {
        return tracksList.get(Int);
    }

    /**
     * Remove track from this track library if the track is in this track library.
     * @param id name of the track wanted to remove from
     * @return whether the track has been successfully removed.
     */
    @Override
    public boolean remove(String id) {
        if (this.contain(id) != null) {
            this.tracksList.remove(this.contain(id));
            tinydb.remove(id+"t");
            return true;
        } else {
            return false;
        }

    }
    /**
     * @return whether the track library is empty or not
     */
    @Override
    public boolean isEmpty() {
        return tracksList.isEmpty();
    }

    /**
     * Check if the track library contains certain tracks.
     * @param id the name of the track we wanted to check
     * @return the track that corresponds to the id.
     */
    @Override
    public Track contain(String id) {
        for (int i = 0; i < tracksList.size(); i++) {
            if (tracksList.get(i).getId().equals(id)) {
                return tracksList.get(i);
            }
        }
        return null;
    }

    /**
     * Get the list of track in the library.
     * @return ArrayList<Track>
     */
    public ArrayList<Track> getTrackList() { return this.tracksList; }

    /**
     * Get the list of all ids of tracks currently in the library.
     * @return The list of ids.
     */
    public List<String> getTrackPathList() {
        List<String> list = new ArrayList<>();
        for (Track track : tracksList) {
            list.add(track.getPath());
        }
        return list;
    }
}
