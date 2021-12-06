package com.mer.plamer.usecases;

import android.media.MediaPlayer;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.Track;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class to manipulate the music player's state.
 */
public class PlayAction {
    private static String currentTrackID;
    private static final MediaPlayer mediaPlayer = new MediaPlayer();
    private static Playlist currentPlaylist;
    private static ArrayList<Track> shuffleList;
    public static PlayOrder order = PlayOrder.LIST;

    /**
     * Prepares the music player for playing.
     */
    public static void prepare() {
        if(currentTrackID == null){
            try{
                if(!TrackLibraryAction.trackLibrary.isEmpty()){
                    String path = TrackLibraryAction.trackLibrary.getByIndex(0).getPath();
                    mediaPlayer.setDataSource(path);
                    currentTrackID = TrackLibraryAction.trackLibrary.getByIndex(0).getID();
                    mediaPlayer.prepare();
                }
            }
            catch(Exception ignored){
            }
        }
        else{
            try{
                String path = TrackLibraryAction.trackLibrary.get(currentTrackID).getPath();
                mediaPlayer.setDataSource(path);
                mediaPlayer.prepare();
            }
            catch(Exception ignored){
            }
        }
    }

    /**
     * Returns true if and only if the music player is playing.
     * @return true if a track is playing, false otherwise
     */
    public static boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    /**
     * Starts/Resumes the music player if it is not playing.
     */
    public static void play() {
        mediaPlayer.start();
        if(currentPlaylist != null && order != PlayOrder.REPEAT){
            mediaPlayer.setOnCompletionListener(mp -> {
                PlayAction.end();
                PlayAction.next();
                PlayAction.play();
            });
        }
    }

    /**
     * Pauses the music player if it is playing
     */
    public static void pause() {
            mediaPlayer.pause();
    }

    /**
     * Returns the length of the current playing track.
     * @return an int of the length of the current playing track
     */
    public static int getTrackLength() {
        return mediaPlayer.getDuration();
    }

    /**
     * Returns the playing track's current position.
     * @return an int of the current playing track's position
     */
    public static int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    /**
     * Returns the playing track's artist's name.
     * @return a String of the current playing track's artist name
     */
    public static String getArtist() {
        return TrackLibraryAction.trackLibrary.get(currentTrackID).getArtist();
    }

    /**
     * Returns the playing track's title
     * @return a String of the current playing track's title
     */
    public static String getTitle(){
        return TrackLibraryAction.trackLibrary.get(currentTrackID).getTitle();
    }
    /**
     * Sets the progress of the current track to progress * 1000
     * @param progress an int of intended progress
     */
    public static void setPosition(int progress) {
        mediaPlayer.seekTo(progress * 1000);
    }

    /**
     * Set the playback to the provided playlist
     * @param id the id of the intended playlist
     */
    public static void setCurrentPlaylist(String id){
        currentPlaylist = PlaylistLibraryAction.playlistLibrary.getPlaylist(id);
    }

    /**
     * Set the current track's ID
     * @param id the id of the intended track
     */
    public static void setCurrentTrack(String id){
        if(TrackLibraryAction.trackLibrary.contains(id)){
            currentTrackID = id;
        }
    }

    /**
     * Set the current track's id to the next candidate in our playlist and prepare for playback
     */
    public static void next(){
        if(currentPlaylist != null){
            ArrayList<Track> playlist;
            if(order != PlayOrder.SHUFFLE){
                playlist = currentPlaylist.getTracks();
            }
            else{
                playlist = shuffleList;
            }
            int i = 0;
            while(i < playlist.size()){
                if(playlist.get(i).getID().equals(currentTrackID)){
                    i++;
                    break;
                }
                i++;
            }
            if(i < playlist.size()){
                currentTrackID = playlist.get(i).getID();
            }
            else{
                if(order == PlayOrder.SHUFFLE){
                    Collections.shuffle(playlist);
                    shuffleList = playlist;
                }
                currentTrackID = playlist.get(0).getID();
            }
            PlayAction.prepare();
        }
    }

    /**
     * Set the current track's id to the last candidate in our playlist and prepare for playback
     */
    public static void prev(){
        if(currentPlaylist != null){
            ArrayList<Track> playlist;
            if(order != PlayOrder.SHUFFLE){
                playlist = currentPlaylist.getTracks();
            }
            else{
                playlist = shuffleList;
            }
            int i = playlist.size() - 1;
            while(i >= 0){
                if(playlist.get(i).getID().equals(currentTrackID)){
                    i--;
                    break;
                }
                i--;
            }
            if(i >= 0){
                currentTrackID = playlist.get(i).getID();
            }
            else{
                currentTrackID = playlist.get(playlist.size()-1).getID();
            }
            PlayAction.prepare();
        }
    }

    /**
     * Ends the currently playing track and resets the music player. The music player will need to
     * be prepared again in case another track is to be played.
     */
    public static void end() {
        mediaPlayer.reset();
    }

    /**
     * Change loop mode of music player
     */
    public static void loop() {
        mediaPlayer.setLooping(!mediaPlayer.isLooping());
    }

    public static void shuffle(){
        shuffleList = currentPlaylist.getTracks();
        Collections.shuffle(shuffleList);
    }

    /**
     * Enum to symbolize player's playing order
     */
    public enum PlayOrder{
        LIST, REPEAT, SHUFFLE
    }
}