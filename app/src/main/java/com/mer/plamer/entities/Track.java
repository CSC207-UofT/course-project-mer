package com.mer.plamer.entities;

/**
 * Track class stores information of a music track
 */
public class Track {
    private String artist;
    private String title;
    private String length;
    private String genre;
    private final String path;
    private final String track_id;
    private static int ID = 1;


    /**
     * Alternative constructor of a track.
     * @param path the path to the file of such track
     */
    public Track(String path){
        this.path = path;
        this.track_id = String.valueOf(ID);
        this.artist = "";
        this.title = "";
        this.length = "";
        this.genre = "";
        ID++;
    }

    /**
     * Give a track its artist attribute
     * @param artist the artist of this track
     */
    public void setArtist(String artist){
        if(artist != null){
            this.artist = artist;
        }
    }

    /**
     * Give a track its title attribute
     * @param title the title of this track
     */
    public void setTitle(String title){
        if(title != null){
            this.title = title;
        }
    }

    /**
     * Give a track its length attribute
     * @param length the length of this track
     */
    public void setLength(String length){
        if(length != null){
            this.length = length;
        }
    }

    /**
     * Give a track its genre attribute
     * @param genre the genre of this track
     */
    public void setGenre(String genre){
        if(genre != null){
            this.genre = genre;
        }
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
     * get the ID of this track.
     * @return the ID as a string.
     */
    public String getID() { return this.track_id;}

    /**
     * Set the static ID of the Track class to its saved value on every launch.
     * @param saved_id the saved static ID of the Track class.
     */
    public static void setID(int saved_id) { ID = saved_id; }
}
