package com.mer.plamer.userAction;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class PlayAction {
    private final AssetFileDescriptor location;
    private final MediaPlayer mediaPlayer;

    public PlayAction(AssetFileDescriptor src) {
        this.location = src;
        this.mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(src);
            mediaPlayer.prepare();
        }
        catch (Exception ignored){
            // To be implemented later
        }
    }

    public boolean isPlaying() {
        return this.mediaPlayer.isPlaying();
    }

    public void play() {
        if (!this.isPlaying()) {
            this.mediaPlayer.start();
        }
    }

    public void pause(){
        if (this.isPlaying()) {
            this.mediaPlayer.pause();
        }
    }

    public void seek () {}

    public void playback () {}

    public void end () {}
}