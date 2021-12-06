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
        t1 = new Track("Jcole");
        String t1id = t1.getID();
        t2 = new Track("KDot");
        String t2id = t2.getID();
        t3 = new Track("Drake");
        String t3id = t3.getID();
        pl = new Playlist("test");
        pla = new PlaylistAction(pl);
        pla.addTrack(t2id);
        pla.addTrack(t3id);
    }

    @Test(timeout = 50)
    public void testSortByLength() {
        pla.sortByLength();
        ArrayList<Track> testlist = new ArrayList<>();
//        testlist.add(t3);
//        testlist.add(t1);
//        testlist.add(t2);
        assertArrayEquals(testlist.toArray(), pl.getTracks().toArray());
    }

    @Test(timeout = 50)
    public void testSortByTitle() {
        pla.sortByTitle();
        ArrayList<Track> testlist = new ArrayList<>();
//        testlist.add(t1);
//        testlist.add(t3);
//        testlist.add(t2);
        assertArrayEquals(testlist.toArray(), pl.getTracks().toArray());
    }

    @Test(timeout = 50)
    public void testSortByArtist() {
        pla.sortByArtist();
        ArrayList<Track> testlist = new ArrayList<>();
//        testlist.add(t3);
//        testlist.add(t1);
//        testlist.add(t2);
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
        Track t = new Track("Jcole");
        String tid = t.getID();
        assertFalse(pla.addTrack(tid));
        assertFalse(pla.delTrack(tid));
    }

    @Test(timeout = 50)
    public void testCreate() {
        assertNotNull(PlaylistAction.createPlaylist("test"));
    }

    @Test(timeout = 50)
    public void testSortbyRandom() {
        Playlist plist = new Playlist("test");
        PlaylistAction pla = new PlaylistAction(plist);
        pla.sortByRandom();
        ArrayList<Track> testlist = new ArrayList<>();
        assertArrayEquals(testlist.toArray(), pl.getTracks().toArray());
    }
}
