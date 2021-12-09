package com.mer.plamer.controller;


import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.UserAction;
import com.mer.plamer.usecases.UserLibraryAction;
import com.mer.plamer.MyApp;
import com.mer.plamer.TinyDB;

/**
 * Controller for user manipulations
 */
public class UserControl {

    public final UserAction userAction;
    private final TinyDB tinydb;

    /**
     * Constructor of UserControl.
     */
    public UserControl() {
        this.userAction = new UserAction();
        this.tinydb = new TinyDB(MyApp.getContext());
    }

    public UserControl(TinyDB tinydb) {
        this.userAction = new UserAction();
        this.tinydb = tinydb;
    }

    /**
     * Register a new user and add it to userlibrary as well as the local persistent file.
     * @param username the username of the new user.
     * @param password the password of the new user.
     * @return whether if the new user is successfully created.
     */
    public boolean registration(String username, String password) {
        if (UserLibraryAction.userRegister(username, password)) {
            this.userAction.setUser(username);
            tinydb.putObject("UserLibrary", UserLibraryAction.userLibrary);
            return true;
        }
        return false;
    }

    /**
     * Check if a user can login.
     * @param username the username that user entered.
     * @param password the password that user entered.
     * @return whether the login was successful.
     */
    public boolean login_check(String username, String password) {
        if (UserLibraryAction.userLogin(username, password)) {
            this.userAction.setUser(username);
            return true;
        }
        return false;
    }

    /**
     * Get the name of a user.
     * @return the name of the user.
     */
    public String getAccountInfo() {
        if (this.userAction.isNull()) {
            return "No user founded.";
        }
        return this.userAction.getCurrentName();
    }

    /**
     * Scan the local file to gather every previously registered user on every launch.
     */
    public void scanLocal() {
        if (tinydb.objectExists("UserLibrary")) {
            UserLibraryAction.assignLibrary(tinydb.getObject("UserLibrary",
                    UserLibraryAction.userLibrary.getClass()));
        }
    }

    /**
     * Delete a user
     * @param username the username of the user to delete
     * @return true if deleted, false otherwise
     */
    public boolean userDeletion(String username) {
        if (!this.userAction.isAdmin()) {
            return false;
        }
        else if (UserLibraryAction.delete(username)) {
            tinydb.putObject("UserLibrary", UserLibraryAction.userLibrary);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Change the password of the currently registered user.
     * @param new_pass The desired new password that the user wants to change to.
     * @return true if password change is successful, false if the new password is the same as the
     * old one or is the empty string.
     */
    public boolean modifyUserPassword(String new_pass) {
        if (new_pass.equals(this.userAction.getCurrentPassword()) || new_pass.equals("")) {
            return false;
        }
        this.userAction.changePwd(new_pass);
        tinydb.putObject("UserLibrary", UserLibraryAction.userLibrary);
        return true;
    }

    /**
     * Create a playlist for user
     * @param name the name of the intended playlist
     */
    public void createPlaylist(String name){
        PlaylistControl playlistControl = new PlaylistControl();
        playlistControl.add(name);
        int length = PlaylistLibraryAction.getListOfPlaylistId().size();
        String PL_id = PlaylistLibraryAction.getListOfPlaylistId().get(length - 1);
        this.userAction.addPlaylist(PL_id);
        tinydb.putObject("UserLibrary", UserLibraryAction.userLibrary);
    }

    /**
     * Remove a playlist for user
     * @param id the id of such playlist
     */
    public void removePlaylist(String id) {
        this.userAction.getCurrentPlaylists().remove(id);
        tinydb.putObject("UserLibrary", UserLibraryAction.userLibrary);
    }


}

