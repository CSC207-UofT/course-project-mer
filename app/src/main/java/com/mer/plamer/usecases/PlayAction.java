package com.mer.plamer.usecases;

import android.media.MediaPlayer;

import com.mer.plamer.entities.Track;

/**
 * Class to manipulate the music player's state.
 */
public class PlayAction {
    private static String currentTrackID;
    private static final MediaPlayer mediaPlayer = new MediaPlayer();

    /**
     * Prepares the music player for playing.
     */
    public static void prepare() {
        try{
            mediaPlayer.setDataSource(TrackLibraryAction.trackLibrary.get(0).getPath());
            currentTrackID = TrackLibraryAction.trackLibrary.get(0).getId();
            mediaPlayer.prepare();
        }
        catch(Exception ignored){
            // To be implemented later
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
     * Starts/Resumes the music player if it is not playing, otherwise pauses it.
     */
    public static void playPause() {
        if (!isPlaying()) {
            mediaPlayer.start();
        }
        else {
            mediaPlayer.pause();
        }
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
        return TrackLibraryAction.trackLibrary.contain(currentTrackID).getArtist();
    }

    /**
     * Returns the playing track's title
     * @return a String of the current playing track's title
     */
    public static String getTitle(){
        return TrackLibraryAction.trackLibrary.contain(currentTrackID).getTitle();
    }
    /**
     * Sets the progress of the current track to progress * 1000
     * @param progress an int of intended progress
     */
    public static void setPosition(int progress) {
        mediaPlayer.seekTo(progress * 1000);
    }

    /**
     * Ends the currently playing track and resets the music player. The music player will need to
     * be prepared again in case another track is to be played.
     */
    public static void end() {
        mediaPlayer.reset();
    }
}