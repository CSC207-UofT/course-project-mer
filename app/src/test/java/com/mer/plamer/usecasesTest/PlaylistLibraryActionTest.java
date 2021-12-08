package com.mer.plamer.usecasesTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.usecases.PlaylistLibraryAction;

import org.junit.Test;

import java.util.ArrayList;

public class PlaylistLibraryActionTest {

    @Test(timeout = 50)
    public void testAddDelete() {
        PlaylistLibraryAction.add("test");
        ArrayList<String> plID = PlaylistLibraryAction.search("test");
        String playlistID = plID.get(0);
        assertNotNull(PlaylistLibraryAction.searchGetName(playlistID));
        assertNotNull(PlaylistLibraryAction.getListOfPlaylistSize());
        assertNotNull(PlaylistLibraryAction.getListOfPlaylistName());
        assertNotNull(PlaylistLibraryAction.getListOfPlaylistId());
        assertTrue(PlaylistLibraryAction.delete(playlistID));
        PlaylistLibrary pl1 = new PlaylistLibrary();
        PlaylistLibraryAction.assignLibrary(pl1);
        assertNull(PlaylistLibraryAction.searchGetName(playlistID));
    }


//    @Test(timeout = 50)
//    public void testSearch() {
//        PlaylistLibraryAction pla = new PlaylistLibraryAction();
//        pla.add("test");
//        assertNotNull(pla.search("test"));
//        ArrayList<Track> pl = pla.search("test");
//        assertEquals("test", pl.get(0).getName());
//    }
}
