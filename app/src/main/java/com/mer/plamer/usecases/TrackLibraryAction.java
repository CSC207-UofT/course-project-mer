package com.mer.plamer.usecases;

import android.media.MediaMetadataRetriever;

import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;


import java.util.ArrayList;

/**
 * Actions performed on a trackLibrary
 */
public class TrackLibraryAction {

    public static TrackLibrary trackLibrary = new TrackLibrary();

    /**
     * Delete the track in the track library.
     * @param track_id the id of the playlist.
     * @return Whether the track is successfully removed or not.
     */
    public static boolean delete(String track_id) {
        return trackLibrary.remove(track_id);
    }

    /**
     * Search for required tracks.
     * @param keyword user provided keyword.
     * @return a array list of the IDs of required tracks.
     */
    public static ArrayList<String> search(String keyword) {
        ArrayList<String> searchTrack = new ArrayList<>();
        String lKeyword = keyword.toLowerCase();
        for (Track t : trackLibrary.getTrackList()){
            if (t.getArtist().toLowerCase().contains(lKeyword)
                    || t.getTitle().toLowerCase().contains(lKeyword)
                    || t.getGenre().toLowerCase().contains(lKeyword)){
                searchTrack.add(t.getID());
            }
        }
        return searchTrack;
    }

    /**
     * Get the name of search result from its id.
     *
     * @param id ID from search result
     * @return the title of the required track.
     */
    public static String searchGetName(String id) {
        for (Track t : trackLibrary.getTrackList()) {
            if (t.getID().equals(id)) {
                return t.getTitle();
            }
        }
        return null;
    }

    /**
     * add a track to the track library.
     * @param path the path of the track we want to add.
     */
    public static void add(String path) {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(path);
        Track track = trackLibrary.create(path);
        track.setArtist(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
        track.setTitle(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
        track.setGenre(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE));
        track.setLength(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
        trackLibrary.add(track);
    }

    /**
     * Alternative add method for testing
     * @param path the path of the track we want to add
     * @param mmr android's MediaMetadataRetriever
     */
    public static void add(String path, MediaMetadataRetriever mmr) {
        mmr.setDataSource(path);
        Track track = trackLibrary.create(path);
        track.setArtist(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
        track.setTitle(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
        track.setGenre(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE));
        track.setLength(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
        trackLibrary.add(track);
    }

    /**
     * Return the static id of Track class.
     * @return the static id.
     */
    public static int getStaticId() { return Track.getStaticId();}

    /**
     * Set the static ID of the Track class to its saved value on every launch.
     * @param saved_id the saved static ID of the Track class.
     */
    public static void setID(int saved_id) { Track.setID(saved_id); }

    /**
     * Assign a previously stored library as the new library.
     * @param library the previously stored library.
     */
    public static void assignLibrary(TrackLibrary library) {
        trackLibrary = library;
    }

    /**
     * Make the library empty.
     */
    public static void emptyTheLibrary() {
        trackLibrary.emptyTheLibrary();
    }

    /**
     * Returns the title, artist, and length of a track
     * @param id the id of a track
     * @return the metadata of such track
     */
    public static ArrayList<String> fetchMetadata(String id){
        ArrayList<String> metadata = new ArrayList<>();
        Track t = TrackLibraryAction.trackLibrary.get(id);
        metadata.add(t.getTitle());
        metadata.add(t.getArtist());
        metadata.add(t.getLength());
        return metadata;
    }

    /**
     * Returns the size of track library
     * @return the number of tracks in the track library
     */
    public static int getLibrarySize(){
        return trackLibrary.getTrackList().size();
    }

    /**
     * Returns all tracks' IDs in a list
     * @return all tracks' IDs in a list
     */
    public static ArrayList<String> fetchAllTrackIDs(){
        ArrayList<Track> tracklist = trackLibrary.getTrackList();
        ArrayList<String> IDList = new ArrayList<>();
        for(Track t:tracklist){
            IDList.add(t.getID());
        }
        return IDList;
    }

    /**
     * Returns true if the track library contains no media
     * @return true if there's no media in the library, false otherwise
     */
    public static boolean isEmpty(){
        return trackLibrary.isEmpty();
    }
}
