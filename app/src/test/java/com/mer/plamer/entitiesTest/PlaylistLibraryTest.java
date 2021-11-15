package com.mer.plamer.entitiesTest;
import org.junit.Test;
import static org.junit.Assert.*;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.UserLibrary;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class PlaylistLibraryTest {

    @Test(timeout = 50)
    public void testAdd(){
        PlaylistLibrary pl = new PlaylistLibrary();
        Playlist p = new Playlist("test");
        pl.add(p);
        assertFalse(pl.isEmpty());
    }

    @Test(timeout = 50)
    public void testRemove(){
        PlaylistLibrary pl = new PlaylistLibrary();
        Playlist p = new Playlist("test");
        pl.add(p);
        pl.remove("1");
        assertTrue(pl.isEmpty());
    }
}
