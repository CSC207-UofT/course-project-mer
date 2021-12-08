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
    public static ArrayList<String> search(String keyword) {
        ArrayList<String> searchUser = new ArrayList<>();
        String lKeyword = keyword.toLowerCase();
        for (User u : userLibrary.getUsersList()) {
            if (u.getUsername().toLowerCase().contains(lKeyword)) {
                searchUser.add(u.getUsername());
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
     * Register a new user.
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @return The new created user.
     */
    public static boolean userRegister(String username, String password) {
        if (userLibrary.get(username) != null) {
            return false;
        }
        else if (username.equals("")) {
            return false;
        }
        userLibrary.add(userLibrary.create(username, password));
        return true;
    }

    /**
     * Attempt to login to a user account if userid and password matches.
     * @param username the userid which the user entered.
     * @param password the password which the user entered.
     * @return the User that was logged in.
     */
    public static boolean userLogin(String username, String password) {
        User target = userLibrary.get(username);
        if (target != null) {
            return target.getPassword().equals(password);
        }
        return false;
    }

    /**
     * Return an arraylist of all the username of users that had previously registered on this
     * device.
     * @return The arraylist of all the username of the users.
     */
    public static ArrayList<String> getAllUserName() {
        ArrayList<User> UserList = userLibrary.getUsersList();
        ArrayList<String> name_list = new ArrayList<>();
        for (User user : UserList) {
            String username = user.getUsername();
            name_list.add(username);
        }
        return name_list;
    }

    public static ArrayList<String> getUserPlaylist(String username) {
        return UserLibraryAction.userLibrary.get(username).getPlaylists();
    }

    /**
     * Assign a previously stored library as the new library.
     * @param library the previously stored library.
     */
    public static void assignLibrary(UserLibrary library) {
        userLibrary = library;
    }

}