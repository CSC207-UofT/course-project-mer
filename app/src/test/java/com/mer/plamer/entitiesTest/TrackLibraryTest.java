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
        t1 = new Track("Jcole");
        t1.setArtist("J");
        t2 = new Track("KDot");
        t2.setArtist("K");
        t3 = new Track("Drake");
        t3.setArtist("D");
    }

    @Test(timeout = 50)
    public void testActions() {
        TrackLibrary tl = new TrackLibrary();
        assertTrue(tl.isEmpty());
        tl.add(t1);
        assertFalse(tl.isEmpty());
        tl.add(t2);
//        assertEquals(t1, tl.get(0));
        assertTrue(tl.remove("12"));
        assertFalse(tl.remove("3"));
//        assertNotNull(tl.contain("13"));
//        assertNull(tl.contain("123"));
        ArrayList<Track> testlist = new ArrayList<>();
        testlist.add(t2);
        assertArrayEquals(testlist.toArray(), tl.getTrackList().toArray());
        ArrayList<String> pathlist = new ArrayList<>();
        pathlist.add("KDot");
        assertArrayEquals(pathlist.toArray(), tl.getTrackPathList().toArray());
        tl.emptyTheLibrary();
        assertTrue(tl.isEmpty());


    }
}
