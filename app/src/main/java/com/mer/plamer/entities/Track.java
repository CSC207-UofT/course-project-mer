package com.mer.plamer.entities;
import java.util.ArrayList;
import java.io.File;
import android.media.MediaMetadataRetriever;

public class Track {
    private final String artist;
    private final String title;
    private final String length;
    private final String genre;
    private final ArrayList<String> comments;
    private final File mediaFile;

    public Track(String location){
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(location);
        this.artist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
        this.title = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
        this.length = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        this.genre = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE);
        this.comments = new ArrayList<>();
        this.mediaFile = new File(location);
    }

    public String getArtist(){
        return this.artist;
    }

    public String getTitle(){
        return this.title;
    }

    public String getLength(){
        return this.length;
    }

    public String getGenre(){
        return this.genre;
    }
}
