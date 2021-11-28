package com.mer.plamer.entitiesTest;
import org.junit.Test;
import static org.junit.Assert.*;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;

import org.junit.Before;
import java.util.List;

public class PlaylistLibraryTest {

    @Test
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
        assertTrue(pl.remove(p.getId()));
        assertFalse(pl.remove("asd"));
    }

    @Test(timeout = 50)
    public void testCreate(){
        PlaylistLibrary pl = new PlaylistLibrary();
        pl.create("test");
        assertEquals("test", pl.getPlaylists().get(0).getName());
    }

    @Test(timeout = 50)
    public void testIsempty(){
        PlaylistLibrary pl = new PlaylistLibrary();
        assertTrue(pl.isEmpty());
    }

    @Test(timeout = 50)
    public void testContain(){
        PlaylistLibrary pl = new PlaylistLibrary();
        Playlist plist = new Playlist("test");
        String testid = plist.getId();
        pl.add(plist);
        assertEquals("test", pl.contain(testid).getName());
    }
}
