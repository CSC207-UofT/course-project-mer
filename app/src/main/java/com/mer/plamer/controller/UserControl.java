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

    // TODO: Implement userDeletion
    public void userDeletion() {

    }

    /**
     * Change the password of the currently registered user.
     * @param new_pass The desired new password that the user wants to change to.
     * @return True if password change is successful, false if the new password is the same as the
     * old one or is the empty string.
     */
    public boolean modifyUserPassword(String new_pass) {
        if (new_pass.equals(this.userAction.getCurrentPassword()) || new_pass.equals("")) {
            return false;
        }
        this.userAction.changePwd(new_pass);
        return true;
    }
}

