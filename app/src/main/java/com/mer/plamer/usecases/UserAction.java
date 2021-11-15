package com.mer.plamer.usecases;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.Track;

/**
 * Actions that a user can perform
 */
public class UserAction {

    private User user;
    public static PlaylistLibrary playlistLibrary;

    /**
     * Constructor for UserAction, it will have no user at the beginning.
     */
    public UserAction() {
        this.user = null;
    }

    public void SetUser(User user) {
        this.user = user;
    }

    public boolean IsNull() {
        return this.user == null;
    }

    /**
     * Change the password of a user.
     * @param new_pass The desired password that this user want to change to.
     * @return true if the password is changed, false if did not or is the same as the old one.
     */
    public boolean changePwd(String new_pass) {
        if (this.IsNull() || new_pass.equals(this.user.getPassword())) {
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
        if (this.IsNull() || new_name.equals(this.user.getUsername())) {
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
        if (this.IsNull()) {
            return false;
        }
        Playlist new_pl = new Playlist(PL_name);
        this.user.getPlaylists().add(new_pl);
        playlistLibrary.add(new_pl);
        return true;
    }

    public boolean uploadTrack(Track track) {
        if (this.IsNull() || this.user.getUploadedTracks().contains(track)) {
            return false;
        }
        this.user.getUploadedTracks().add(track);
        return true;
    }
}
