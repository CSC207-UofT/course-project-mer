package com.mer.plamer.entitiesTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;

import org.junit.Test;

import java.util.ArrayList;

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
        assertNotNull(pl.create("test"));
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
//        pl.add(plist);
//        plistassertEquals("test", pl.contain(testid).getName());
    }

    @Test(timeout = 50)
    public void testgetPlaylist() {
        PlaylistLibrary pl = new PlaylistLibrary();
        Playlist plist = new Playlist("test");
        pl.add(plist);
        ArrayList<Playlist> testlist = new ArrayList<>();
        testlist.add(plist);
        assertArrayEquals(testlist.toArray(), pl.getPlaylists().toArray());
    }

    @Test(timeout = 50)
    public void testgetPlaylist2() {
        PlaylistLibrary pl = new PlaylistLibrary();
        Playlist plist = new Playlist("test");
        pl.add(plist);
        String plid = plist.getId();
        assertNotNull(pl.getPlaylist(plid));
        assertNull(pl.getPlaylist("idk"));
        assertNotNull(pl.getListofPlaylistSize());
        assertNotNull(pl.getListofPlaylistName());
        assertNotNull(pl.getListOfPlaylistId());
    }

}
