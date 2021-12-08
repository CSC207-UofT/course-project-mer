package com.mer.plamer.entitiesTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import com.mer.plamer.entities.UserLibrary;
import com.mer.plamer.entities.User;

public class UserLibraryTest {

    @Test(timeout = 50)
    public void testAdd(){
        UserLibrary ul = new UserLibrary();
        User u = new User("test", "test123");
        ul.add(u);
        assertFalse(ul.isEmpty());
    }

    @Test(timeout = 50)
    public void testRemove(){
        UserLibrary ul = new UserLibrary();
        User u = new User("test", "test123");
        ul.add(u);
        assertTrue(ul.remove("test"));
        assertFalse(ul.remove("nonexistentuser"));
    }

    @Test(timeout = 50)
    public void testContain() {
        UserLibrary ul = new UserLibrary();
        User u = new User("test", "test123");
        ul.add(u);
//        assertEquals(u, ul.contain("test"));
//        assertNull(ul.contain("neuser"));
    }

    @Test(timeout = 50)
    public void testGetuserslist(){
        UserLibrary ul = new UserLibrary();
        User u = new User("test", "test123");
        ul.add(u);
        ArrayList<User> testlist = new ArrayList<>();
        testlist.add(u);
        assertEquals(2, ul.getUsersList().size());
        User u2 = new User("steve", "balmer");
        ul.add(u2);
        testlist.add(u2);
        assertEquals(3, ul.getUsersList().size());
        ul.create("testuser", "321");

    }

}
