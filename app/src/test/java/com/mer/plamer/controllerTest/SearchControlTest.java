package com.mer.plamer.controllerTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.mer.plamer.controller.SearchControl;
import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.UserLibrary;
import com.mer.plamer.usecases.UserLibraryAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.TrackLibraryAction;
import org.junit.Test;

public class SearchControlTest {

    @Test
    public void testTrackSearch() {
        Track t1 = new Track("test");
        t1.setArtist("kendrick");
        Track t2 = new Track("test2");
        t2.setArtist("drake");
        TrackLibrary tl = new TrackLibrary();
        tl.add(t1);
        assertEquals(0, SearchControl.searchTrack("drake").size());
        tl.add(t2);
        TrackLibraryAction.assignLibrary(tl);
        assertNotNull(SearchControl.searchTrack("drake"));
        assertEquals(1, SearchControl.searchTrack("drake").size());
    }

    @Test
    public void testPlaylistSearch() {
        Playlist pl = new Playlist("test");
        PlaylistLibrary pll = new PlaylistLibrary();
        pll.add(pl);
        PlaylistLibraryAction.assignLibrary(pll);
        assertEquals(0, SearchControl.searchPlaylist("what").size());
        assertEquals(1, SearchControl.searchPlaylist("test").size());
    }

    @Test
    public void testUserSearch() {
        User u = new User("name", "pwd");
        UserLibrary ul = new UserLibrary();
        ul.add(u);
        UserLibraryAction.assignLibrary(ul);
        assertEquals(0, SearchControl.searchUser("test").size());
        assertEquals(1, SearchControl.searchUser("name").size());
    }
}
