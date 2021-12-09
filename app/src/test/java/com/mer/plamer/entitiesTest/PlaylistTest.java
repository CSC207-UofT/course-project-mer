package com.mer.plamer.entitiesTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.Track;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class PlaylistTest {

    @Test(timeout = 50)
    public void  testGetID(){
        Playlist pl = new Playlist("test");
        String plid = pl.getId();
        assertEquals(plid, pl.getId());
        Playlist pl1 = new Playlist("test1");
        String pl1id = pl1.getId();
        assertEquals(pl1id, pl1.getId());
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
                return a.getArtist().compareTo(b.getArtist());
            }
        }
        Track t1 = new Track("Jcole");
        t1.setArtist("J");
        Track t2 = new Track("KDot");
        t2.setArtist("K");
        Track t3 = new Track("Drake");
        t3.setArtist("D");
        pl.addTrack(t2);
        pl.addTrack(t3);
        pl.addTrack(t1);
        pl.sort(new Sortbyname());
        ArrayList<Track> testlist = new ArrayList<>();
        testlist.add(t3);
        testlist.add(t1);
        testlist.add(t2);
        assertArrayEquals(testlist.toArray(), pl.getTracks().toArray());
    }
}
