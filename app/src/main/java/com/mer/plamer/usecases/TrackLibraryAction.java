package com.mer.plamer.usecases;

import android.media.MediaMetadataRetriever;

import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;


import java.sql.Array;
import java.util.ArrayList;

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
     * Search the required track.
     * @param keyword user provided keyword.
     * @return a arrayelist the required tracks.
     */
    public static ArrayList<Track> search(String keyword) {
        ArrayList<Track> searchTrack = new ArrayList<>();
        for (Track t : trackLibrary.getTrackList()){
            if (t.getArtist().contains(keyword) || t.getTitle().contains(keyword)
                    || t.getGenre().contains(keyword)){
                searchTrack.add(t);
            }
        }
        return searchTrack;
    }

    /**
     * add a track to the track library.
     * @param path the path of the track we want to add.
     */
    public static Track add(String path) {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(path);
        Track track = trackLibrary.create(path);
        track.setArtist(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
        track.setTitle(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
        track.setGenre(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE));
        track.setLength(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
        trackLibrary.add(track);
        return track;
    }


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

}
