package com.mer.plamer.entities;

import java.util.ArrayList;

public class UserLibrary implements Storable<User> {
    private final ArrayList<User> usersList;

    public UserLibrary() {
        this.usersList = new ArrayList<User>();
    }

    // Add a new user to the user library.
    @Override
    public void add(User new_user) {
        this.usersList.add(new_user);
    }

    // Permanently delete a specific user by their username
    @Override
    public boolean remove(String username) {
        return true;
    }

    // Check if the list is empty
    @Override
    public boolean isEmpty() {
        return this.usersList.isEmpty();
    }

    // Return a specific user by their username, return null if no matching user name is found.
    @Override
    public User contain(String id) {
        for (User user : this.usersList) {
            if (user.getUsername().equals(id)) {
                return user;
            }
        }
        return null;
    }

    // Check the log in username and password, return true when they match.
    public boolean check_login(String id, String pass) {
        User target = this.contain(id);
        if (target != null) {
            return target.getPassword().equals(pass);
        }
        return false;
    }

}

