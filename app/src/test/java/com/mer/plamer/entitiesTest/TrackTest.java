package com.mer.plamer.entitiesTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import com.mer.plamer.entities.Track;

public class TrackTest {
    Track t;

    @Before
    public void setUp() {
        t = new Track("Jcole", "amari", "420", "hiphop","1");
    }

    @Test(timeout = 50)
    public void testTrackConstructor() {
        assertEquals("Jcole",t.getArtist());
        assertEquals("420", t.getLength());
        assertEquals("hiphop", t.getGenre());
        assertEquals("amari", t.getTitle());
        assertEquals("1", t.getId());
        assertEquals("", t.getPath());
    }

}
