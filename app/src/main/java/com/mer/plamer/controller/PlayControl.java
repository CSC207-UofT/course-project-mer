package com.mer.plamer.controller;

import android.content.Context;
import android.media.MediaPlayer;

import com.mer.plamer.userAction.PlayAction;


public class PlayControl {
    PlayAction playaction;
    private final Context ctx;
    private final MediaPlayer mediaPlayer;

    public PlayControl(Context ctx) {
        this.ctx = ctx;
        this.mediaPlayer = new MediaPlayer();
    }

    public void load(int resourceID){
        try{
            mediaPlayer.setDataSource(ctx.getResources().openRawResourceFd(resourceID));
            mediaPlayer.prepare();
        }
        catch (Exception ignored){
            // To be implemented later
        }
    }

    public void play(){
        if(!this.mediaPlayer.isPlaying()){
            this.mediaPlayer.start();
        }

    }

    public void pause(){
        if(this.mediaPlayer.isPlaying()){
            this.mediaPlayer.pause();
        }
    }

    public void seek () {}

    public void playback () {}
}
