package com.mer.plamer.usecasesTest;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.Track;
import com.mer.plamer.usecases.PlaylistAction;

import java.util.ArrayList;

public class PlaylistActionTest {
    Track t1;
    Track t2;
    Track t3;
    Playlist pl;
    PlaylistAction pla;

    @Before
    public void setUp() {
        t1 = new Track("Jcole", "Amari", "420", "hiphop","1");
        t2 = new Track("KDot", "GOD", "520", "hiphop","2");
        t3 = new Track("Drake", "ChicagoFS", "320", "hiphop","3");
        pl = new Playlist("test");
        pla = new PlaylistAction(pl);
        pla.addTrack(t1);
        pla.addTrack(t2);
        pla.addTrack(t3);
    }

    @Test(timeout = 50)
    public void testSortByLength() {
        pla.sortByLength();
        ArrayList<Track> testlist = new ArrayList<>();
        testlist.add(t3);
        testlist.add(t1);
        testlist.add(t2);
        assertArrayEquals(testlist.toArray(), pl.getTracks().toArray());
    }

    @Test(timeout = 50)
    public void testSortByTitle() {
        pla.sortByTitle();
        ArrayList<Track> testlist = new ArrayList<>();
        testlist.add(t1);
        testlist.add(t3);
        testlist.add(t2);
        assertArrayEquals(testlist.toArray(), pl.getTracks().toArray());
    }

    @Test(timeout = 50)
    public void testSortByArtist() {
        pla.sortByArtist();
        ArrayList<Track> testlist = new ArrayList<>();
        testlist.add(t3);
        testlist.add(t1);
        testlist.add(t2);
        assertArrayEquals(testlist.toArray(), pl.getTracks().toArray());
    }


    @Test(timeout = 50)
    public void testStatus() {
        pla.setStatus("RANDOM");
        assertEquals("RANDOM", pl.getStatus());
    }

    @Test(timeout = 50)
    public void testAddDelete() {
        Playlist plist = new Playlist("test");
        PlaylistAction pla = new PlaylistAction(plist);
        Track t = new Track("Jcole", "amari", "420", "hiphop","1");
        assertTrue(pla.addTrack(t));
        assertTrue(pla.delTrack(t));
    }
}
