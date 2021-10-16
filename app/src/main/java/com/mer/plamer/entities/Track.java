package com.mer.plamer.entities;
import java.util.ArrayList;
import java.io.File;

public class Track {
//    private final String artist;
//    private final String title;
//    private final double length;
//    private String genre;
//    private final ArrayList<String> comments;
    private final File mediaFile;

    public Track(String location){
//        this.artist = artist;
//        this.title = title;
//        this.length = length;
//        this.genre = genre;
//        this.comments = new ArrayList<String>();
        this.mediaFile = new File(location);
    }
}
