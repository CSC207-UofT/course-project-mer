package com.mer.plamer.entities;


import java.util.ArrayList;
import java.util.List;

public class TrackLibrary implements Storable<Track> {
    private final ArrayList<Track> tracksList;

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
        tracksList.add(track);
    }

    /**
     * create a new track.
     * @param path the path of the track.
     * @return the created track.
     */
    public Track create(String path) {
        return new Track(path);
    }

    /**
     * Get the track at index Int.
     * @param Int the index of the track we want to get.
     * @return the track at the index.
     */
    public Track getByIndex(int Int) {
        return tracksList.get(Int);
    }

    /**
     * Returns the track with given id. Return null if such track does not exist
     * @param id the id of a track needed
     * @return the track with such id
     */
    @Override
    public Track get(String id){
        for(Track t:tracksList){
            if(t.getID().equals(id)){
                return t;
            }
        }
        return this.getByIndex(0);
    }

    /**
     * Remove track from this track library if the track is in this track library.
     * @param id name of the track wanted to remove from
     * @return whether the track has been successfully removed.
     */
    @Override
    public boolean remove(String id) {
        if (this.get(id) != null) {
            this.tracksList.remove(this.get(id));
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
     * @return true if track is in the library, false otherwise
     */
    public boolean contains(String id){
        for(Track t:tracksList){
            if(t.getID().equals(id)){
                return true;
            }
        }
        return false;
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

    /**
     * Empty the Track Library.
     */
    public void emptyTheLibrary() {
        tracksList.clear();
    }
}
