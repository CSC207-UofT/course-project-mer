package com.mer.plamer.entitiesTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.Track;

public class UserTest {
    User u;

    @Before
    public void setUp() {
        u = new User("testUser", "testing");
    }

    @Test(timeout = 50)
    public void testUserConstructor() {
        assertEquals("testUser", u.getUsername());
        assertEquals("testing", u.getPassword());
    }

    @Test(timeout = 50)
    public void testSetUsername() {
        u.setUsername("testUser123");
        assertEquals("testUser123", u.getUsername());
    }

    @Test(timeout = 50)
    public void testSetPassword() {
        u.setPassword("testing123");
        assertEquals("testing123", u.getPassword());
    }

    @Test(timeout = 50)
    public void testGetPlayLists() {
        ArrayList<Playlist> al = new ArrayList<>();
        assertArrayEquals(al.toArray(), u.getPlaylists().toArray());
    }

    @Test(timeout = 50)
    public void testUploadedTracks() {
        ArrayList<Track> tracklist = new ArrayList<>();
        assertArrayEquals(tracklist.toArray(), u.getUploadedTracks().toArray());
    }
}
