package com.mer.plamer.usecases;

import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.UserLibrary;
import com.mer.plamer.usecases.UserAction;

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
     * @param username the username of the required user.
     * @return the required user or null if no result found.
     */
    @Override
    public User search(String username) {
       return userLibrary.contain(username);
    }

    /**
     * add a user to the user library.
     * @param user the user we want to add.
     */
    @Override
    public void add(User user) {
       userLibrary.add(user);
    }

    public User User_register(String userid, String password) {
        if (userLibrary.contain(userid) != null) {
            return null;
        }
        User new_user = new User(userid, password);
        this.add(new_user);
        return new_user;
    }

    public User User_login(String userid, String password) {
        if (!userLibrary.check_login(userid, password)) {
            return null;
        }
        return userLibrary.contain(userid);
    }
}
