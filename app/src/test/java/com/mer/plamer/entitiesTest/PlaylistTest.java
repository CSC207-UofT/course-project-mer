package com.mer.plamer.entitiesTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.Track;

public class PlaylistTest {
    @Test(timeout = 50)
    public void testGetLength(){
        Playlist pl = new Playlist("test");
        Track t = new Track("samplepath");
        Track t1 = new Track("samplepath");
        assertEquals(0, pl.getLength());
        pl.addTrack(t);
        assertEquals(1, pl.getLength());
        pl.addTrack(t1);
        assertEquals(2, pl.getLength());
    }

    @Test(timeout = 50)
    public void testGetName(){
        Playlist pl = new Playlist("test");
        assertEquals("test", pl.getName());
    }

    @Test(timeout = 50)
    public void  testGetID(){
        Playlist pl = new Playlist("test");
        assertEquals("0", pl.getId());
    }

    @Test(timeout = 50)
    public void testGetStatus(){
        Playlist pl = new Playlist("test");
        assertEquals("REPEAT", pl.getStatus());
    }

    @Test(timeout = 50)
    public void testSetStatus(){
        Playlist pl = new Playlist("test");
        assertTrue(pl.setStatus("RANDOM"));
        assertFalse(pl.setStatus("WHAT"));
    }

    @Test(timeout = 50)
    public void testSetName(){
        Playlist pl = new Playlist("test");
        pl.setName("test2");
        assertEquals("test2", pl.getName());
    }

    @Test(timeout = 50)
    public void testAddTrack(){
        Playlist pl = new Playlist("test");
        Track t1 = new Track("InternalStorage/Music/Test1.mp3");
        Track t2 = new Track("InternalStorage/Music/Test2.mp3");
        assertTrue(pl.addTrack(t1));
        assertTrue(pl.addTrack(t2));
        assertFalse(pl.addTrack(t1));
    }

    @Test(timeout = 50)
    public void testDelTrack(){
        Playlist pl = new Playlist("test");
        Track t1 = new Track("InternalStorage/Music/Test1.mp3");
        Track t2 = new Track("InternalStorage/Music/Test2.mp3");
        Track t3 = new Track("InternalStorage/Music/Test3.mp3");
        pl.addTrack(t1);
        pl.addTrack(t2);
        assertTrue(pl.delTrack(t1));
        assertTrue(pl.delTrack(t2));
        assertFalse(pl.delTrack(t3));

    }
}
