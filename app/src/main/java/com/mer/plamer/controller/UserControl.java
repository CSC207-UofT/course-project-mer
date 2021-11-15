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
            this.userAction.SetUser(userLibraryAction.userRegister(username, password));
            return true;
        }
        return false;
    }

    public boolean login_check(String username, String password) {
        if (userLibraryAction.User_login(username, password) != null) {
            this.userAction.SetUser(userLibraryAction.User_login(username, password));
            return true;
        }
        return false;
    }

    // TODO: Implement getAccountInfo
    public void getAccountInfo() {

    }

    // TODO: Implement userDeletion
    public void userDeletion() {

    }

    // TODO: modifyUserInformation
    public void modifyUserInformation() {
    }

}

