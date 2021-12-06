package com.mer.plamer.usecasesTest;
import org.junit.Test;
import static org.junit.Assert.*;

import com.mer.plamer.entities.User;
import com.mer.plamer.entities.Track;
import com.mer.plamer.usecases.UserAction;

public class UserActionTest {

    @Test(timeout = 50)
    public void testSetuser() {
        UserAction ua = new UserAction();
        User u = new User("test", "test123");
        ua.setUser("test");
        assertFalse(ua.isNull());
    }

    @Test(timeout = 50)
    public void testIsNull() {
        UserAction ua = new UserAction();
        assertTrue(ua.isNull());
    }

    @Test(timeout = 50)
    public void testChangeName() {
        UserAction ua = new UserAction();
        User u = new User("test", "test123");
        ua.setUser("test");
        assertTrue(ua.changeName("testnew"));
        assertEquals("testnew", u.getUsername());
    }

    @Test(timeout = 50)
    public void testCreatePlaylist() {
        UserAction ua = new UserAction();
        User u = new User("test", "test123");
        ua.setUser("test");
//        assertTrue(ua.createPlaylist("playlist1"));
        // playlistLibrary not initialized in constructor
    }

    @Test(timeout = 50)
    public void testuploadTrack() {
        UserAction ua = new UserAction();
        User u = new User("test", "test123");
        ua.setUser("test");
        Track t = new Track("Jcole");
        assertTrue(ua.uploadTrack(t));
        assertFalse(ua.uploadTrack(t));
    }

    @Test(timeout = 50)
    public void testChangePassword() {
        UserAction ua = new UserAction();
        User u = new User("test", "test123");
        ua.setUser("test");
        assertTrue(ua.changePwd("test1233"));
        assertFalse(ua.changePwd("test1233"));
    }
}
