package com.mer.plamer.usecases;

import com.mer.plamer.entities.User;
import com.mer.plamer.entities.UserLibrary;

import java.util.ArrayList;

public class UserLibraryAction implements LibraryAction<User> {

    public static UserLibrary userLibrary = new UserLibrary();

    /**
     * Delete user in the user library completely, only admin can perform this method.
     * @param username the username of the user that will be deleted.
     * @return Whether the user is successfully removed or not.
     */
   @Override
   public boolean delete(String username) {
       return userLibrary.remove(username);
   }

    /**
     * Search the required user.
     * @param keyword provided by the user.
     * @return the required user or null if no result found.
     */
    @Override
    public ArrayList<User> search(String keyword) {
        ArrayList<User> searchUser = new ArrayList<>();
        for (User u : userLibrary.getUsersList()){
            if (u.getUsername().contains(keyword)){
                searchUser.add(u);
            }
        }
        return searchUser;
    }

    /**
     * add a user to the user library.
     * @param name the username of the user we want to add.
     * @param password the password of the user we want to add.
     */

    public void add(String name ,String password) {
        userLibrary.add(userLibrary.create(name, password));
    }

    public UserLibrary getUserLibrary() {
        return userLibrary;
    }

    public User find(String username) {
        return this.getUserLibrary().contain(username);
    }

    public User userRegister(String username, String password) {
        if (userLibrary.contain(username) != null) {
            return null;
        }
        else if (username.equals("")) {
            return null;
        }
        this.add(username, password);
        return userLibrary.contain(username);
    }

    public User User_login(String userid, String password) {
        if (!userLibrary.check_login(userid, password)) {
            return null;
        }
        return userLibrary.contain(userid);
    }
}
