package com.mer.plamer.entitiesTest;
import org.junit.Test;
import static org.junit.Assert.*;

import com.mer.plamer.entities.TrackLibrary;
import com.mer.plamer.entities.Track;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrackLibraryTest {
    Track t1;
    Track t2;
    Track t3;


    @Before
    public void setUp() {
        t1 = new Track("Jcole", "amari", "420", "hiphop","1");
        t2 = new Track("KDot", "GOD", "520", "hiphop","2");
        t3 = new Track("Drake", "ChicagoFS", "320", "hiphop","3");
    }

    @Test(timeout = 50)
    public void testActions() {
        TrackLibrary tl = new TrackLibrary();
        assertTrue(tl.isEmpty());
        tl.add(t1);
        assertFalse(tl.isEmpty());
        tl.add(t2);
        assertEquals(t1, tl.get(0));
        assertTrue(tl.remove("2"));
        assertFalse(tl.remove("3"));
        assertEquals(t1, tl.contain("1"));
        assertNull(tl.contain("123"));
        ArrayList<Track> testlist = new ArrayList<>();
        testlist.add(t1);
        assertArrayEquals(testlist.toArray(), tl.getTrackList().toArray());
        ArrayList<String> pathlist = new ArrayList<>();
        pathlist.add("");
        assertArrayEquals(pathlist.toArray(), tl.getTrackPathList().toArray());
        tl.emptyTheLibrary();
        assertTrue(tl.isEmpty());


    }
}
