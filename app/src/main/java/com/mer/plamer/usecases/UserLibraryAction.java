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
    @SuppressLint("StaticFieldLeak")
    private static final TinyDB tinydb = new TinyDB(MyApp.getContext());

    /**
     * Delete user in the user library completely, only admin can perform this method.
     * @param username the username of the user that will be deleted.
     * @return Whether the user is successfully removed or not.
     */
   public static boolean delete(String username) {
       return userLibrary.remove(username);
   }

    /**
     * Search the required user.
     * @param keyword provided by the user.
     * @return the required user or null if no result found.
     */
    public static ArrayList<User> search(String keyword) {
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

    public static void add(String name ,String password) {
        userLibrary.add(userLibrary.create(name, password));
    }

    /**
     * Get the user library.
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
        }
        else if (username.equals("")) {
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

    /**
     * Scan the local created users on every launch.
     */
    public static void scanLocal() {
        int i = 0;
        int current_id = tinydb.getInt("user_static_id");
        while ( i <= current_id) {
            if (tinydb.objectExists(String.valueOf(i)+"u")) {
                userLibrary.add(tinydb.getObject(String.valueOf(i) + "u", User.class));
            }
            i++;
        }
        User.changeId(current_id + 1);
    }
}
