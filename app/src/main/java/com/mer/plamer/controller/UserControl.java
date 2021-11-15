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
        if (userLibraryAction.User_register(username, password) != null) {
            this.userAction.SetUser(userLibraryAction.User_register(username, password));
            return true;
        }
        return false;
    }

    public void getAccountInfo() {

    }

    public void userDeletion() {

    }

    public void modifyUserInformation() {
    }

}

