package com.mer.plamer.controller;

import android.media.MediaMetadataRetriever;
import android.os.Environment;

import com.mer.plamer.usecases.TrackLibraryAction;
import com.mer.plamer.MyApp;
import com.mer.plamer.TinyDB;

import java.io.File;

public class TrackLibraryControl {

    private final TinyDB tinydb;

    /**
     * Constructor of TrackLibraryControl.
     */
    public TrackLibraryControl() {
        this.tinydb = new TinyDB(MyApp.getContext());
    }

    public TrackLibraryControl(TinyDB tinydb) {
        this.tinydb = tinydb;
    }

    /**
     * Add a new Track to tracklibrary as well as the local persistent file.
     * @param path the path of the new track.
     */
    public void add(String path) {
        TrackLibraryAction.add(path);
        tinydb.putInt("track_static_id", TrackLibraryAction.getStaticId());
        tinydb.putObject("TrackLibrary", TrackLibraryAction.trackLibrary);
    }

    public void add(String path, MediaMetadataRetriever mmr) {
        TrackLibraryAction.add(path, mmr);
        tinydb.putInt("track_static_id", TrackLibraryAction.getStaticId());
        tinydb.putObject("TrackLibrary", TrackLibraryAction.trackLibrary);
    }

    /**
     * Remove a track of track_id from tracklibrary as well as the local persisten file.
     * @param track_id of the track we want to remove.
     */
    public void remove(String track_id) {
        TrackLibraryAction.delete(track_id);
        tinydb.putObject("TrackLibrary", TrackLibraryAction.trackLibrary);
    }

    /**
     * Scan the local music on every launch (or when the user want to).
     */
    public void scanLocal() {
        TrackLibraryAction.emptyTheLibrary();
        File dir = Environment.getExternalStorageDirectory();
        if (tinydb.objectExists("TrackLibrary")) {
            TrackLibraryAction.assignLibrary(tinydb.getObject("TrackLibrary",
                    TrackLibraryAction.trackLibrary.getClass()));
            TrackLibraryAction.setID(tinydb.getInt("track_static_id"));
        }
        recursiveSongSearch(dir);
    }

    /**
     * Helper method to recursively search for songs in the storage.
     * @param dir The directory to search.
     */
    private void recursiveSongSearch(File dir) {
        if (!dir.isDirectory()) {
            if (dir.getName().endsWith(".mp3")) {
                if (!TrackLibraryAction.trackLibrary.getTrackPathList().
                        contains(dir.getAbsolutePath())) {
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
