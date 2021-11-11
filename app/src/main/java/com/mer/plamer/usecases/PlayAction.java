package com.mer.plamer.usecases;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

public class PlayAction {
    private static String location;
    private static MediaPlayer mediaPlayer = new MediaPlayer();

    public static void prepare() {
        try{
            mediaPlayer.setDataSource(TrackLibraryAction.trackLibrary.get(0).getPath());
            mediaPlayer.prepare();
        }
        catch(Exception ignored){
            // To be implemented later
        }
    }

    public static boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    public static void playPause() {
        if (!isPlaying()) {
            mediaPlayer.start();
        }
        else {
            mediaPlayer.pause();
        }
    }

    public static void seek () {}

    public static void playback () {}

    public static void end () {}
}