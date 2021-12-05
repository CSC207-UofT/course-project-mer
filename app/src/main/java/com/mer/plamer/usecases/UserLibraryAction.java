package com.mer.plamer.usecases;

import android.annotation.SuppressLint;

import com.mer.plamer.MyApp;
import com.mer.plamer.TinyDB;
import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.UserLibrary;

import java.util.ArrayList;

public class UserLibraryAction {

    public static UserLibrary userLibrary = new UserLibrary();

    /**
     * Delete user in the user library completely, only admin can perform this method.
     *
     * @param username the username of the user that will be deleted.
     * @return Whether the user is successfully removed or not.
     */
    public static boolean delete(String username) {
        return userLibrary.remove(username);
    }

    /**
     * Search the required user.
     *
     * @param keyword provided by the user.
     * @return the required user or null if no result found.
     */
    public static ArrayList<User> search(String keyword) {
        ArrayList<User> searchUser = new ArrayList<>();
        for (User u : userLibrary.getUsersList()) {
            if (u.getUsername().contains(keyword)) {
                searchUser.add(u);
            }
        }
        return searchUser;
    }

    /**
     * add a user to the user library.
     *
     * @param name     the username of the user we want to add.
     * @param password the password of the user we want to add.
     */

    public static void add(String name, String password) {
        userLibrary.add(userLibrary.create(name, password));
    }

    /**
     * Get the user library.
     *
     * @return the user library.
     */
    public static UserLibrary getUserLibrary() {
        return userLibrary;
    }

    public static User find(String username) {
        return getUserLibrary().contain(username);
    }

    public static User userRegister(String username, String password) {
        if (userLibrary.contain(username) != null) {
            return null;
        } else if (username.equals("")) {
            return null;
        }
        add(username, password);
        return userLibrary.contain(username);
    }

    public static User User_login(String userid, String password) {
        if (!userLibrary.check_login(userid, password)) {
            return null;
        }
        return userLibrary.contain(userid);
    }

    public static void assignLibrary(UserLibrary library) {
        userLibrary = library;
    }

}