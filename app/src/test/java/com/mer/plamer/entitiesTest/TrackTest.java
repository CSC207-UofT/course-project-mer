package com.mer.plamer.entitiesTest;

import static org.junit.Assert.assertEquals;

import com.mer.plamer.entities.Track;

import org.junit.Before;
import org.junit.Test;

public class TrackTest {
    Track t;

    @Before
    public void setUp() {
        t = new Track("path");
    }

    @Test(timeout = 50)
    public void testTrackConstructor() {
        assertEquals("path", t.getPath());
    }

    @Test(timeout = 50)
    public void testArtistMethods(){
        t.setArtist("Jcole");
        assertEquals("Jcole", t.getArtist());
    }

    @Test(timeout = 50)
    public void testLengthMethods(){
        t.setLength("420");
        assertEquals("420", t.getLength());
    }

    @Test(timeout = 50)
    public void testGenreMethods(){
        t.setGenre("hiphop");
        assertEquals("hiphop", t.getGenre());
    }

    @Test(timeout = 50)
    public void testTitleMethods(){
        t.setTitle("amari");
        assertEquals("amari", t.getTitle());
    }
}
