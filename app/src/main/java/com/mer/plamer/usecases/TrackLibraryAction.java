package com.mer.plamer.usecases;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.media.MediaMetadataRetriever;

import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;
import com.mer.plamer.MyApp;
import com.mer.plamer.TinyDB;

import java.io.File;
import java.util.ArrayList;

public class TrackLibraryAction {

    public static TrackLibrary trackLibrary = new TrackLibrary();
    @SuppressLint("StaticFieldLeak")
    private static final TinyDB tinydb = new TinyDB(MyApp.getContext());

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
     * Scan the local music on every launch (or when the user want to).
     */
    public static void scanLocal() {
        trackLibrary.emptyTheLibrary();
        File dir = Environment.getExternalStorageDirectory();
        int i = 0;
        int current_id = tinydb.getInt("track_static_id");
        while ( i <= current_id) {
            if (tinydb.objectExists(i +"t")) {
                trackLibrary.add(tinydb.getObject(i + "t", Track.class));
            }
            i++;
        }
        Track.setID(current_id + 1);
        recursiveSongSearch(dir);
    }

    /**
     * Helper method to recursively search for songs in the storage.
     * @param dir The directory to search.
     */
    private static void recursiveSongSearch(File dir) {
        if (!dir.isDirectory()) {
            if (dir.getName().endsWith(".mp3")) {
                if (!trackLibrary.getTrackPathList().contains(dir.getAbsolutePath())) {
                    add(dir.getAbsolutePath());
                }
            }
        }
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                recursiveSongSearch(file);
            }
        }

    }
}
