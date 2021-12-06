package com.mer.plamer.controller;


import com.mer.plamer.usecases.UserAction;
import com.mer.plamer.usecases.UserLibraryAction;
import com.mer.plamer.MyApp;
import com.mer.plamer.TinyDB;


public class UserControl {

    public UserAction userAction;
    private final TinyDB tinydb = new TinyDB(MyApp.getContext());

    public UserControl() {
        this.userAction = new UserAction();
    }

    public boolean registration(String username, String password) {
        if ( UserLibraryAction.userRegister(username, password) != null) {
            this.userAction.setUser(UserLibraryAction.getUserLibrary().get(username));
            tinydb.putObject("UserLibrary", UserLibraryAction.getUserLibrary());
            return true;
        }
        return false;
    }

    public boolean login_check(String username, String password) {
        if (UserLibraryAction.User_login(username, password) != null) {
            this.userAction.setUser(UserLibraryAction.getUserLibrary().get(username));
            return true;
        }
        return false;
    }

    public String getAccountInfo() {
        if (this.userAction.getUser() == null) {
            return "there is no user.";
        }
        return this.userAction.getUser().getUsername();
    }

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

