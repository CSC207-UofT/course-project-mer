package com.mer.plamer.entities;

import java.util.ArrayList;

public class UserLibrary implements Storable<User> {
    private final ArrayList<User> usersList;

    public UserLibrary() {
        this.usersList = new ArrayList<User>();
    }

    /**
     * Add a new user to the user library.
     * @param new_user the new user
     */
    @Override
    public void add(User new_user) {
        this.usersList.add(new_user);
    }

    /**
     * Permanently delete a specific user by their username
     * @param username the name of the user
     */
    @Override
    public boolean remove(String username) {
        if (this.contain(username) != null) {
            this.usersList.remove(this.contain(username));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if the list is empty
     * @return true if the list is empty and false if not
     */
    @Override
    public boolean isEmpty() {
        return this.usersList.isEmpty();
    }

    /**
     * Check if user is part of this UserLibrary
     * @param id the id of the user
     * @return username of user
     */
    @Override
    public User contain(String id) {
        for (User user : this.usersList) {
            if (user.getUsername().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Check the log in username and password
     * @param id the id of the user
     * @param pass the password of ths user
     * @return true if username matches password and false otherwise
     */
    public boolean check_login(String id, String pass) {
        User target = this.contain(id);
        if (target != null) {
            return target.getPassword().equals(pass);
        }
        return false;
    }

}
