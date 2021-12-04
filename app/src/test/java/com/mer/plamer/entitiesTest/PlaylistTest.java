package com.mer.plamer.entitiesTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.Track;

public class PlaylistTest {

    @Test(timeout = 50)
    public void  testGetID(){
        Playlist pl = new Playlist("test");
        assertEquals("2", pl.getId());
        Playlist pl1 = new Playlist("test1");
        assertEquals("3", pl1.getId());
    }

    @Test(timeout = 50)
    public void testGetLength(){
        Playlist pl = new Playlist("test");
        Track t = new Track("test");
        Track t1 = new Track("test");
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
        Track t1 = new Track("test");
        Track t2 = new Track("KDot");
        assertTrue(pl.addTrack(t1));
        assertTrue(pl.addTrack(t2));
        assertFalse(pl.addTrack(t1));
    }

    @Test(timeout = 50)
    public void testDelTrack(){
        Playlist pl = new Playlist("test");
        Track t1 = new Track("Jcole");
        Track t2 = new Track("KDot");
        Track t3 = new Track("Drake");
        pl.addTrack(t1);
        pl.addTrack(t2);
        assertTrue(pl.delTrack(t1));
        assertTrue(pl.delTrack(t2));
        assertFalse(pl.delTrack(t3));

    }

    @Test(timeout = 50)
    public void testGettracks() {
        Playlist pl = new Playlist("test");
        Track t1 = new Track("Drake");
        pl.addTrack(t1);
        ArrayList<Track> testlist = new ArrayList<>();
        testlist.add(t1);
        assertArrayEquals(testlist.toArray(), pl.getTracks().toArray());
    }


    @Test(timeout = 50)
    public void  testSort(){
        Playlist pl = new Playlist("test");
        class Sortbyname implements Comparator<Track> {
            public int compare(Track a, Track b){
                return a.getTitle().compareTo(b.getTitle());
            }
        }
        Track t1 = new Track("Jcole");
        Track t2 = new Track("KDot");
        Track t3 = new Track("Drake");
        pl.addTrack(t2);
        pl.addTrack(t3);
        pl.addTrack(t1);
        pl.sort(new Sortbyname());
        ArrayList<Track> testlist = new ArrayList<>();
        testlist.add(t1);
        testlist.add(t3);
        testlist.add(t2);
        assertArrayEquals(testlist.toArray(), pl.getTracks().toArray());
    }
}
