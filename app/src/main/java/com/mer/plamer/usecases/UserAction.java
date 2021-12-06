package com.mer.plamer.usecases;

import com.mer.plamer.entities.Admin;
import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.Track;

/**
 * Actions that a user can perform
 */
public class UserAction {

    private User user;

    /**
     * Constructor for UserAction, it will have no user at the beginning.
     */
    public UserAction() {
        this.user = null;
    }

    /**
     * Set the user this UserAction is dealing with.
     * @param username the username of the user in interest.
     */
    public void setUser(String username) {
        this.user = UserLibraryAction.userLibrary.get(username);
    }

    /**
     * Return the user this UserAction is dealing with.
     * @return The user this UserAction is dealing with.
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Check if this UserAction is no user assign.
     * @return Whether there is a user assigned.
     */
    public boolean isNull() {
        return this.user == null;
    }

    /**
     * Check if the current user is a administrator.
     * @return True if the user is an administrator, false if it is not.
     */
    public boolean isAdmin() {
        return this.getUser() instanceof Admin;
    }

    /**
     * Get the username of the current user of this userAction.
     * @return The username of the current user.
     */
    public String getCurrentName() {
        return this.getUser().getUsername();
    }

    /**
     * Get the password of the current user of this userAction.
     * @return The password of the current user.
     */
    public String getCurrentPassword() {
        return this.getUser().getPassword();
    }

    /**
     * Change the password of a user.
     * @param new_pass The desired password that this user want to change to.
     * @return true if the password is changed, false if did not or is the same as the old one.
     */
    public boolean changePwd(String new_pass) {
        if (this.isNull() || new_pass.equals(this.user.getPassword())) {
            return false;
        }
        this.user.setPassword(new_pass);
        return true;
    }

    /**
     * Change the username of a user.
     * @param new_name The desired username that this user want to change to.
     * @return true if the username is changed, false if did not or is the same as the old one.
     */
    public boolean changeName(String new_name) {
        if (this.isNull() || new_name.equals(this.user.getUsername())) {
            return false;
        }
        this.user.setUsername(new_name);
        return true;
    }

    /**
     * Create a new and empty playlist that belongs to this user.
     * @param PL_name the name of the new play list.
     * @return true if the playlist is created, false otherwise.
     */
    public boolean createPlaylist(String PL_name) {
        if (this.isNull()) {
            return false;
        }
        Playlist new_pl = new Playlist(PL_name);
        this.user.getPlaylists().add(new_pl);
        PlaylistLibraryAction.playlistLibrary.add(new_pl);
        return true;
    }

}
