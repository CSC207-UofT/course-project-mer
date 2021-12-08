package com.mer.plamer.usecasesTest;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;
import com.mer.plamer.usecases.TrackLibraryAction;

import org.junit.Test;

import java.util.ArrayList;

public class TrackLibraryActionTest {

    @Test(timeout = 50)
    public void testActions() {
        TrackLibrary tl = new TrackLibrary();
        Track t1 = new Track("test");
        t1.setArtist("Jcole");
        t1.setTitle("MiddleChild");
        t1.setLength("100");
        String t1id = t1.getID();
        tl.add(t1);
        TrackLibraryAction.assignLibrary(tl);
        assertNotNull(TrackLibraryAction.search("Jcole"));
        assertNotNull(TrackLibraryAction.searchGetName(t1id));
        assertNotNull(TrackLibraryAction.fetchMetadata(t1id));
        assertEquals(1, TrackLibraryAction.getLibrarySize());
        ArrayList<String> testlist = new ArrayList<>();
        testlist.add(t1id);
        assertArrayEquals(testlist.toArray(), TrackLibraryAction.fetchAllTrackIDs().toArray());

        assertTrue(TrackLibraryAction.delete(t1id));
        TrackLibraryAction.emptyTheLibrary();

    }

}
