//package com.mer.plamer.controllerTest;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//import com.mer.plamer.controller.PlaylistControl;
//import com.mer.plamer.entities.Playlist;
//import com.mer.plamer.entities.PlaylistLibrary;
//import com.mer.plamer.entities.Track;
//import com.mer.plamer.usecases.PlaylistAction;
//
//import org.junit.Before;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class PlaylistControlTest {
//    public Playlist pl;
//    public PlaylistAction pla;
//    public PlaylistControl plc;
//
//
//    @Before
//    public void setUp() {
//        pl = new Playlist("test");
//        pla = new PlaylistAction(pl);
//        plc = new PlaylistControl();
//        plc.setPlaylistAction(pla);
//    }
//
//    @Test(timeout = 50)
//    public void testPlaylistAction() {
//        Track t1 = new Track("test");
//        String t1id = t1.getID();
//        assertFalse(plc.trackAdd(t1id));
//        assertFalse(plc.trackRemove(t1id));
//    }
//
//    @Test(timeout = 50)
//    public void testCreate() {
//        plc.createAddPlaylist("test");
//        assertEquals(0, pl.getLength());
//        plc.setStatus("RANDOM");
//    }
//
//    @Test(timeout = 50)
//    public void testSort() {
//        assertTrue(plc.sort("Title"));
//        assertTrue(plc.sort("Artist"));
//        assertTrue(plc.sort("Length"));
//        assertTrue(plc.sort("Random"));
//        assertFalse(plc.sort("IDK"));
//    }
//}
