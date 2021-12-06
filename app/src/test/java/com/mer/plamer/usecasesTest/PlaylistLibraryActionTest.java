package com.mer.plamer.usecasesTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.ArrayList;
import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.Track;
import com.mer.plamer.usecases.PlaylistLibraryAction;

public class PlaylistLibraryActionTest {

    @Test(timeout = 50)
    public void testAddDelete() {
        PlaylistLibraryAction pla = new PlaylistLibraryAction();
        pla.add("test");
        assertFalse(pla.delete("123"));

    }

    @Test(timeout = 50)
    public void testSearch() {
        PlaylistLibraryAction pla = new PlaylistLibraryAction();
        pla.add("test");
        assertNotNull(pla.search("test"));
        ArrayList<Track> pl = pla.search("test");
        assertEquals("test", pl.get(0).getName());
    }
}
