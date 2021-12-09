package com.mer.plamer.controllerTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import com.mer.plamer.gateway.TinyDB;

import com.mer.plamer.controller.PlaylistControl;
import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;
import com.mer.plamer.usecases.PlaylistAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.TrackLibraryAction;

@RunWith(MockitoJUnitRunner.class)
public class PlaylistControlTest {

    @Test
    public void testPLC() {
        TinyDB tinydb = mock(TinyDB.class);
        PlaylistControl plc = new PlaylistControl(tinydb);

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

        Track t2 = new Track("asd");
        String t2id = t2.getID();
        tl.add(t2);

        TrackLibraryAction.assignLibrary(tl);

        plc.setPlaylistAction(pla);

        assertTrue(plc.trackRemove(t1id));

        assertTrue(plc.trackAdd(t2id));
    }

    @Test
    public void testSort() {
        TinyDB tinydb = mock(TinyDB.class);
        PlaylistControl plc = new PlaylistControl(tinydb);
        PlaylistAction pla = new PlaylistAction();
        PlaylistLibraryAction.add("test");
        String testplID = PlaylistLibraryAction.search("test").get(0);
        pla.setPlaylist(testplID);
        PlaylistLibraryAction.add("asd");
        plc.setPlaylistAction(pla);

        TrackLibrary tl = new TrackLibrary();
        Track t1 = new Track("test");
        t1.setArtist("Jcole");
        t1.setTitle("MiddleChild");
        t1.setLength("100");
        tl.add(t1);
        TrackLibraryAction.assignLibrary(tl);

        assertTrue(plc.sort("Title"));
        assertTrue(plc.sort("Artist"));
        assertTrue(plc.sort("Length"));
        assertTrue(plc.sort("Random"));
        assertFalse(plc.sort("FALSE"));
    }

    @Test
    public void testAddDel() {
        TinyDB tinydb = mock(TinyDB.class);
        PlaylistControl plc = new PlaylistControl(tinydb);
        PlaylistAction pla = new PlaylistAction();
        PlaylistLibraryAction.add("test");
        String testplID = PlaylistLibraryAction.search("test").get(0);
        pla.setPlaylist(testplID);
        PlaylistLibraryAction.add("asd");
        plc.setPlaylistAction(pla);

        plc.add("fdsa");
        plc.remove(testplID);
        plc.scanLocal();
        plc.setStatus("RANDOM");

    }
}