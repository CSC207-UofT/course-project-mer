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
        String t1id = t1.getID();
        String t2id = t2.getID();
        assertTrue(tl.remove(t1id));
        assertNotNull(tl.create("asd"));
        assertTrue(tl.contains(t2id));
        assertFalse(tl.contains("asd"));
        assertNotNull(tl.getTrackList());
        assertNotNull(tl.getTrackPathList());
        tl.emptyTheLibrary();
        assertTrue(tl.isEmpty());


    }
}
