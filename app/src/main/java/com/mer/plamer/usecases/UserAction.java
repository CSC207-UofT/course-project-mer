package com.mer.plamer.usecases;

import android.content.Intent;

import com.mer.plamer.entities.Admin;
import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.Track;

import java.util.ArrayList;

/**
 * Actions that a user can perform
 */
public class UserAction {

    public static User user;

    /**
     * Constructor for UserAction, it will have no user at the beginning.
     */
    public UserAction() {
    }

    /**
     * Set the user this UserAction is dealing with.
     *
     * @param username the username of the user in interest.
     */
    public void setUser(String username) {
        user = UserLibraryAction.userLibrary.get(username);
    }

    /**
     * Return the user this UserAction is dealing with.
     *
     * @return The user this UserAction is dealing with.
     */
    public User getUser() {
        return user;
    }

    /**
     * Check if this UserAction is no user assign.
     *
     * @return Whether there is a user assigned.
     */
    public boolean isNull() {
        return user == null;
    }

    public boolean isAdmin() {
        return this.getUser() instanceof Admin;
    }

    public String getCurrentName() {
        return this.getUser().getUsername();
    }

    public String getCurrentPassword() {
        return this.getUser().getPassword();
    }

    public ArrayList<String> getCurrentPlaylists() {
        return this.getUser().getPlaylists();
    }

    public ArrayList<Playlist> ToPlaylist() {
        ArrayList<Playlist> PL_list = new ArrayList<>();
        for (String id : this.getCurrentPlaylists()) {
            Playlist PL = PlaylistLibraryAction.playlistLibrary.get(id);
            PL_list.add(PL);
        }
        return PL_list;
    }

    public ArrayList<String> Playlistname() {
        ArrayList<Playlist> PL_list = this.ToPlaylist();
        ArrayList<String> name_list = new ArrayList<String>();
        for (Playlist PL : PL_list) {
            String name = PL.getName();
            name_list.add(name);
        }
        return name_list;
    }

    public ArrayList<Integer> Playlistsize() {
        ArrayList<Playlist> PL_list = this.ToPlaylist();
        ArrayList<Integer> size_list = new ArrayList<Integer>();
        for (Playlist PL : PL_list) {
            Integer size = PL.getLength();
            size_list.add(size);
        }
        return size_list;
    }

    /**
     * Change the password of a user.
     *
     * @param new_pass The desired password that this user want to change to.
     * @return true if the password is changed, false if did not or is the same as the old one.
     */
    public boolean changePwd(String new_pass) {
        if (this.isNull() || new_pass.equals(user.getPassword())) {
            return false;
        }
        user.setPassword(new_pass);
        return true;
    }

    /**
     * Change the username of a user.
     *
     * @param new_name The desired username that this user want to change to.
     * @return true if the username is changed, false if did not or is the same as the old one.
     */
    public boolean changeName(String new_name) {
        if (this.isNull() || new_name.equals(user.getUsername())) {
            return false;
        }
        user.setUsername(new_name);
        return true;
    }

    /**
     * Add the id of a new and empty playlist that belongs to this user to user's playlists id list.
     *
     * @param playlist_id the id of the new playlist.
     */
    public void addPlaylist(String playlist_id) {
            user.getPlaylists().add(playlist_id);
    }

}
