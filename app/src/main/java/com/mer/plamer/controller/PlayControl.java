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
     * Changes the current play mode and return the mode
     * @return a String of the output message
     */
    public static String changePlayMode(){
        if(PlayAction.order == PlayAction.PlayOrder.LIST){
            PlayAction.order = PlayAction.PlayOrder.REPEAT;
            PlayAction.loop();
            return "Repeat ON";
        }
        else if(PlayAction.order == PlayAction.PlayOrder.REPEAT){
            PlayAction.order = PlayAction.PlayOrder.SHUFFLE;
            PlayAction.shuffle();
            PlayAction.loop();
            return "Shuffle";
        }
        else{
            PlayAction.order = PlayAction.PlayOrder.LIST;
            return "Repeat OFF";
        }
    }

    /**
     * Play the next track in current playlist
     */
    public static void next(){
        PlayAction.end();
        PlayAction.next();
        if(PlayAction.order == PlayAction.PlayOrder.REPEAT){
            PlayAction.loop();
        }
    }

    /**
     * Play the last track in current playlist
     */
    public static void prev(){
        PlayAction.end();
        PlayAction.prev();

        if(PlayAction.order == PlayAction.PlayOrder.REPEAT){
            PlayAction.loop();

        }
    }

    /**
     * Give PlayAction a track and playlist for upcoming playback
     * @param playlistID the ID of the intended playlist, use "NONE" if no playlist intended
     * @param trackID the ID of the intended track
     */
    public static void setMedia(String playlistID, String trackID){
        PlayAction.setCurrentPlaylist(playlistID);
        PlayAction.setCurrentTrack(trackID);
        PlayAction.end();
        PlayAction.prepare();
        PlayAction.play();
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
