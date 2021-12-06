package com.mer.plamer.usecases;

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

    /**
     * Find if a user is in the library and return if it exits.
     * @param username the username of the user if exists.
     * @return the User if exists.
     */
    public static User find(String username) {
        return getUserLibrary().get(username);
    }

    /**
     * Register a new user.
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @return The new created user.
     */
    public static User userRegister(String username, String password) {
        if (userLibrary.get(username) != null) {
            return null;
        } else if (username.equals("")) {
            return null;
        }
        add(username, password);
        return userLibrary.get(username);
    }

    /**
     * Attempt to login to a user account if userid and password matches.
     * @param userid the userid which the user entered.
     * @param password the password which the user entered.
     * @return the User that was logged in.
     */
    public static User User_login(String userid, String password) {
        if (!userLibrary.check_login(userid, password)) {
            return null;
        }
        return userLibrary.get(userid);
    }

    /**
     * Assign a previously stored library as the new library.
     * @param library the previously stored library.
     */
    public static void assignLibrary(UserLibrary library) {
        userLibrary = library;
    }

}