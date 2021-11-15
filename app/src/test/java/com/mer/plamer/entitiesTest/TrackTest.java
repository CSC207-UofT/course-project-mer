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
        t = new Track("InternalStorage/Music/sample.mp3");
    }

    @Test(timeout = 50)
    public void testTrackConstructor() {
        assertEquals("sampleartist",t.getArtist());
        assertEquals("sampleLength", t.getLength());
        assertEquals("sampleGenre", t.getGenre());
        assertEquals("sample", t.getTitle());
        assertEquals("ID", t.getId());
        assertEquals("InternalStorage/Music/sample.mp3", t.getPath());

    }

}
