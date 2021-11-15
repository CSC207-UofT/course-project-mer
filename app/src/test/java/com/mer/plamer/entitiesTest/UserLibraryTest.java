package com.mer.plamer.entitiesTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
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
        ul.remove("test");
        assertTrue(ul.isEmpty());
    }


}
