package com.mer.plamer.usecasesTest;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;
import com.mer.plamer.usecases.PlaylistAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.TrackLibraryAction;

import java.util.ArrayList;

public class PlaylistActionTest {

    @Test(timeout = 50)
    public void testConstructor(){
        PlaylistAction pla = new PlaylistAction();
        PlaylistLibraryAction.add("test");
        String testplID = PlaylistLibraryAction.search("test").get(0);
        pla.setPlaylist(testplID);
        assertNotNull(PlaylistAction.createPlaylist("test2"));
    }

    @Test(timeout = 50)
    public void testAddDelete() {
        PlaylistAction pla = new PlaylistAction();
        PlaylistLibraryAction.add("test");
        String testplID = PlaylistLibraryAction.search("test").get(0);
        pla.setPlaylist(testplID);
        TrackLibrary tl = new TrackLibrary();
        Track t1 = new Track("test");
        t1.setArtist("Jcole");
        t1.setTitle("MiddleChild");
        t1.setLength("100");
        String t1id = t1.getID();
        tl.add(t1);
        TrackLibraryAction.assignLibrary(tl);
        assertTrue(pla.addTrack(t1id));
        assertTrue(pla.delTrack(t1id));
        pla.sortByRandom();
        pla.sortByArtist();
        pla.sortByTitle();
        pla.sortByLength();
        pla.setStatus("RANDOM");
        assertNotNull(PlaylistAction.getAllTrackId(testplID));
    }
}
