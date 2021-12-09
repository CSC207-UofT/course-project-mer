package com.mer.plamer.entities;

/**
 * An admin of this player app
 */
public class Admin extends User{

    /**
     * Constructor of admin
     * @param name the name of admin user
     * @param password the password of admin user
     * @param bool whether this will be an admin or not
     */
    public Admin(String name, String password, boolean bool) {
        super(name, password, bool);
    }
}
