package com.mer.plamer.entities;

import com.mer.plamer.MyApp;
import com.mer.plamer.TinyDB;

import java.util.ArrayList;

public class UserLibrary implements Storable<User> {
    private final ArrayList<User> usersList;
    private final TinyDB tinydb = new TinyDB(MyApp.getContext());

    /**
     * Constructor for UserLibrary.
     */
    public UserLibrary() {
        this.usersList = new ArrayList<>();
    }

    /**
     * Add a new user to the user library.
     * @param new_user the new user
     */
    @Override
    public void add(User new_user) {
        tinydb.putObject(new_user.getId() + "u", new_user);
        this.usersList.add(new_user);
    }

    /**
     * Create a new User.
     * @param username The Username of the new user.
     * @param password The password of the new user.
     * @return The user created.
     */
    public User create(String username, String password) {
        User new_user = new User(username,password);
        if (tinydb.getInt("user_static_id") != 0) {
            tinydb.remove("user_static_id");
        }
        tinydb.putInt("user_static_id", Integer.parseInt(new_user.getId()));
        return new_user;
    }

    /**
     * Permanently delete a specific user by their username
     * @param username the name of the user
     */
    @Override
    public boolean remove(String username) {
        User target = this.contain(username);
        if (target != null) {
            this.usersList.remove(target);
            tinydb.remove(target.getId() + "u");
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

    /**
     * Get the list of users in the library
     * @return ArrayList<User>
     */
    public ArrayList<User> getUsersList() { return this.usersList; }
}
