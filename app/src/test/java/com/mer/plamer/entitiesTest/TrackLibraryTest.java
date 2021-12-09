package com.mer.plamer.entitiesTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;

import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void testProperties() {
        TrackLibrary tl = new TrackLibrary();
        tl.add(t1);
        tl.add(t2);
        tl.add(t3);
        assertEquals(t3, tl.getByIndex(2));
    }
}
