package com.mer.plamer.entities;

import java.util.ArrayList;

public class UserLibrary implements Storable<User> {
    private final ArrayList<User> usersList;

    /**
     * Constructor for UserLibrary.
     * Construct a new user which is the admin of the app, who can delete user from the userlibrary.
     */
    public UserLibrary() {
        this.usersList = new ArrayList<>();
        Admin admin = new Admin("admin", "adminadmin");
        this.usersList.add(admin);
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
     * Create a new User.
     * @param username The Username of the new user.
     * @param password The password of the new user.
     * @return The user created.
     */
    public User create(String username, String password) {
        return new User(username,password);
    }

    /**
     * Permanently delete a specific user by their username
     * @param username the name of the user
     */
    @Override
    public boolean remove(String username) {
        User target = this.get(username);
        if (target != null) {
            this.usersList.remove(target);
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
    public User get(String id) {
        for (User user : this.usersList) {
            if (user.getUsername().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Get the list of users in the library
     * @return ArrayList<User>
     */
    public ArrayList<User> getUsersList() { return this.usersList; }
}
