package com.mer.plamer.usecases;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;
import com.mer.plamer.MyApp;
import com.mer.plamer.TinyDB;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TrackLibraryAction implements LibraryAction<Track>{

    public static TrackLibrary trackLibrary = new TrackLibrary();
    @SuppressLint("StaticFieldLeak")
    private static final TinyDB tinydb = new TinyDB(MyApp.getContext());

    /**
     * Delete the track in the track library.
     * @param track_id the id of the playlist.
     * @return Whether the track is successfully removed or not.
     */
    public boolean delete(String track_id) {
        return trackLibrary.remove(track_id);
    }

    /**
     * Search the required track.
     * @param keyword user provided keyword.
     * @return a arrayelist the required tracks.
     */
    public ArrayList<Track> search(String keyword) {
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
    public void add(String path) {
        trackLibrary.add(trackLibrary.create(path));
    }

    /**
     * scan the local file to add every track exists when the app restarts.
     */
//    public static void scanLocal() {
//        File musicFolder = new File(Environment.getExternalStorageDirectory(), "Music");
//        File[] files = musicFolder.listFiles();
//
//        for(int i = 0; i < Objects.requireNonNull(files).length; i++){
//            if(files[i].getName().contains(".mp3")){
//                trackLibrary.add(new Track(files[i].getAbsolutePath()));
//            }
//        }
//
//    }

    public static void scanLocal() {
        trackLibrary.emptyTheLibrary();
        File dir = Environment.getExternalStorageDirectory();
        int i = 0;
        int current_id = tinydb.getInt("track_static_id");
        while ( i < current_id) {
            if (tinydb.objectExists(String.valueOf(i)+"t")) {
                trackLibrary.add(tinydb.getObject(String.valueOf(i) + "p", Track.class));
            }
            i++;
        }
        Track.changeId(current_id);
        recursiveSongSearch(dir);
    }

    private static void recursiveSongSearch(File dir) {
        if (!dir.isDirectory()) {
            if (dir.getName().endsWith(".mp3")) {
                if (!trackLibrary.getTrackPathList().contains(dir.getAbsolutePath())) {
                    Track new_track = new Track(dir.getAbsolutePath());
                    trackLibrary.add(new_track);
                    tinydb.putObject(new_track.getId() + "t", new_track);
                    System.out.println(dir.getAbsolutePath());
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
