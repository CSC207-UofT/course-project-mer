package com.mer.plamer.entities;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private final ArrayList<Playlist> playlist;
    private final ArrayList<Track> uploadedTracks;

    /**
     * Constructor of a user.
     * @param name the name os this user.
     * @param password the password of this user.
     */
    public User(String name, String password){
        this.username = name;
        this.password = password;
        this.playlist = new ArrayList<>();
        this.uploadedTracks = new ArrayList<>();
    }

    /**
     * get the username of this user.
     * @return the username of this user.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * get the password of this user.
     * @return password of this user.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * sets the username of this user to a different one.
     * @param name new name for this user.
     */
    public void setUsername(String name) {
        this.username = name;
    }

    /**
     * sets the password of this user to a different one.
     * @param password new password for this user.
     */
    public void setPassword(String password){
        this.password = password;
    }
}
