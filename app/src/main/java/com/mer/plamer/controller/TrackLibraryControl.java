package com.mer.plamer.controller;

import android.os.Environment;

import com.mer.plamer.usecases.TrackLibraryAction;
import com.mer.plamer.MyApp;
import com.mer.plamer.TinyDB;

import java.io.File;

public class TrackLibraryControl {

    private final TinyDB tinydb = new TinyDB(MyApp.getContext());

    public TrackLibraryControl() {};

    public void add(String path) {
        TrackLibraryAction.add(path);
        tinydb.putObject("TrackLibrary", TrackLibraryAction.trackLibrary);
    }

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
