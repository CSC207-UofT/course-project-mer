package com.mer.plamer.entities;
import java.util.ArrayList;

public class playlist {
    String name;
    ArrayList<track> playlist;
    int length;

    public playlist(String name){
        this.name = name;
        this.playlist = new ArrayList<track>();
        this.length = 0;
    }

    public void updateLength(){
        this.length = this.playlist.size();
    }
}
