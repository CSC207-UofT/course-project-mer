package com.mer.plamer.entities;
import java.util.ArrayList;
import android.media.MediaMetadataRetriever;

// TODO: Implement features around comments
/**
 * Track class stores information of a music track
 */
public class Track {
    private final String artist;
    private final String title;
    private final String length;
    private final String genre;
    private final ArrayList<String> comments;
    private final String path;
    private final String track_id;
    private static int id = 0;

    /**
     * Constructor of a track.
     * @param path the directory path to this track.
     */
    public Track(String path){
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(path);
        this.artist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
        this.title = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
        this.length = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        this.genre = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE);
        this.comments = new ArrayList<>();
        this.path = path;
        this.track_id = String.valueOf(id);
        id ++;
    }

    /**
     * get the artist of this track.
     * @return the name of the artist.
     */
    public String getArtist(){
        return this.artist;
    }

    /**
     * get the title of this track.
     * @return the title.
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * get the time needed to play this track.
     * @return the time as a string.
     */
    public String getLength(){
        return this.length;
    }

    /**
     * get the Genre of this track.
     * @return tje genre.
     */
    public String getGenre(){
        return this.genre;
    }

    /**
     * get the path to this track.
     * @return the directory path.
     */
    public String getPath() { return this.path; }

    /**
     * get the id of this track.
     * @return the id as a string.
     */
    public String getId() { return this.track_id;}

    /**
     * Set the static id of the Track class to its saved value on every launch.
     * @param saved_id the saved static id of the Track class.
     */
    public static void changeId(int saved_id) { id = saved_id; }
}
