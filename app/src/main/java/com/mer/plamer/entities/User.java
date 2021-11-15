package com.mer.plamer.entities;

import java.util.ArrayList;

/**
 * A user will store a client's username and password that is used for log in.
 * It also stores all the playlists the user creates and all the tracks it uploads.
 */
public class User {
    private String username;
    private String password;
    private final ArrayList<Playlist> playlists;
    private final ArrayList<Track> uploadedTracks;

    /**
     * Constructor for User. The playlists and uploadedTracks will be empty at the begining.
     * @param name the username of the user.
     * @param password the password of the user
     */
    public User(String name, String password){
        this.username = name;
        this.password = password;
        this.playlists = new ArrayList<>();
        this.uploadedTracks = new ArrayList<>();
    }

    /**
     * @return the username of a User.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @return the password of a User.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @return the list of playlists a User has.
     */
    public ArrayList<Playlist> getPlaylists() {
        return this.playlists;
    }

    /**
     * @return the list of tracks a User uploaded.
     */
    public ArrayList<Track> getUploadedTracks() {
        return this.uploadedTracks;
    }

    /**
     * Change the username of the User.
     * @param name the name that the User wanted to change to.
     */
    public void setUsername(String name) {
        this.username = name;
    }

    /**
     * Change the password of the User.
     * @param password the password that the User wanted to change to.
     */
    public void setPassword(String password){
        this.password = password;
    }
}