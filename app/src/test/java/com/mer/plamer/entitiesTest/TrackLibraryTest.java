package com.mer.plamer.entitiesTest;
import org.junit.Test;
import static org.junit.Assert.*;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.entities.TrackLibrary;
import com.mer.plamer.entities.Track;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TrackLibraryTest {

    @Test(timeout = 50)
    public void testAdd(){
        TrackLibrary tl = new TrackLibrary();
        Track t = new Track("InternalStorage/Music/sample.mp3");
        tl.add(t);
        assertFalse(tl.isEmpty());
    }

    @Test(timeout = 50)
    public void testRemove(){
        TrackLibrary tl = new TrackLibrary();
        Track t = new Track("InternalStorage/Music/sample.mp3");
        tl.add(t);
        tl.remove("sample");
        assertTrue(tl.isEmpty());
    }
}
