package com.mer.plamer.controller;

import com.mer.plamer.usecases.PlayAction;

/**
 * Controller of the playback information and status
 */
public class PlayControl {

    /**
     * Play/Pause the current playback
     */
    public static void playPause(){
        if(PlayAction.isPlaying()){
            PlayAction.pause();
        }
        else{
            PlayAction.play();
        }
    }

    /**
     * Returns the seconds representation of a time in miliseconds
     * @return An int of the time given, in unit of seconds
     */
    public static int toSeconds(int miliseconds){
        return miliseconds / 1000;
    }

    /**
     * Returns the minute seconds representation of a time in miliseconds
     * @return A String of the time given, in MM:SS format
     */
    public static String toMinuteSeconds(int miliseconds){
        return (miliseconds / 1000) / 60 +":"+ (miliseconds / 1000) % 60;
    }

}
