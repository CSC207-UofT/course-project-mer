package com.mer.plamer.controller;

import com.mer.plamer.usecases.UserAction;
import com.mer.plamer.usecases.UserLibraryAction;


public class UserControl {

    UserAction userAction;
    public static UserLibraryAction userLibraryAction = new UserLibraryAction();

    public UserControl() {
        this.userAction = new UserAction();
    }

    public boolean registration(String username, String password) {
        if (userLibraryAction.userRegister(username, password) != null) {
            this.userAction.SetUser(userLibraryAction.getUserLibrary().contain(username));
            return true;
        }
        return false;
    }

    public boolean login_check(String username, String password) {
        if (userLibraryAction.User_login(username, password) != null) {
            this.userAction.SetUser(userLibraryAction.getUserLibrary().contain(username));
            return true;
        }
        return false;
    }

    public String getAccountInfo() {
        return this.userAction.getUser().getUsername();
    }

    // TODO: Implement userDeletion
    public void userDeletion() {

    }

    // TODO: modifyUserInformation
    public void modifyUserInformation() {
    }

}

