package com.mer.plamer.controller;


import com.mer.plamer.usecases.UserAction;
import com.mer.plamer.usecases.UserLibraryAction;
import com.mer.plamer.MyApp;
import com.mer.plamer.TinyDB;


public class UserControl {

    public UserAction userAction;
    private final TinyDB tinydb = new TinyDB(MyApp.getContext());

    /**
     * Constructor of UserControl.
     */
    public UserControl() {
        this.userAction = new UserAction();
    }

    /**
     * Register a new user and add it to userlibrary as well as the local persistent file.
     * @param username the username of the new user.
     * @param password the password of the new user.
     * @return whether if the new user is successfully created.
     */
    public boolean registration(String username, String password) {
        if ( UserLibraryAction.userRegister(username, password) != null) {
            this.userAction.setUser(UserLibraryAction.getUserLibrary().get(username));
            tinydb.putObject("UserLibrary", UserLibraryAction.getUserLibrary());
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
        if (UserLibraryAction.User_login(username, password) != null) {
            this.userAction.setUser(UserLibraryAction.getUserLibrary().get(username));
            return true;
        }
        return false;
    }

    /**
     * Get the name of a user.
     * @return the name of the user.
     */
    public String getAccountInfo() {
        if (this.userAction.getUser() == null) {
            return "there is no user.";
        }
        return this.userAction.getUser().getUsername();
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

    // TODO: Implement userDeletion
    public void userDeletion() {

    }

    // TODO: modifyUserInformation
    public void modifyUserInformation() {
    }

}

