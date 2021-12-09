package com.mer.plamer.usecasesTest;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import android.media.MediaMetadataRetriever;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;
import com.mer.plamer.usecases.TrackLibraryAction;

import org.junit.Test;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class TrackLibraryActionTest {

    @Test(timeout = 50)
    public void testActions() {
        TrackLibrary tl = new TrackLibrary();
        Track t1 = new Track("test");
        t1.setArtist("jcole");
        t1.setTitle("MiddleChild");
        t1.setLength("100");
        String t1id = t1.getID();
        tl.add(t1);
        TrackLibraryAction.assignLibrary(tl);
        assertNotNull(TrackLibraryAction.search("jcole"));
        assertNotNull(TrackLibraryAction.searchGetName(t1id));
        assertNotNull(TrackLibraryAction.fetchMetadata(t1id));
        assertEquals(1, TrackLibraryAction.getLibrarySize());
        ArrayList<String> testlist = new ArrayList<>();
        testlist.add(t1id);
        assertArrayEquals(testlist.toArray(), TrackLibraryAction.fetchAllTrackIDs().toArray());

        assertTrue(TrackLibraryAction.delete(t1id));
        TrackLibraryAction.emptyTheLibrary();

    }


    @Test
    public void testProperties() {
        TrackLibrary tl = new TrackLibrary();
        Track t1 = new Track("test");
        t1.setArtist("jcole");
        t1.setTitle("MiddleChild");
        t1.setLength("100");

        tl.add(t1);
        TrackLibraryAction.assignLibrary(tl);
        TrackLibraryAction.setID(2);
        assertEquals(2, TrackLibraryAction.getStaticId());

        MediaMetadataRetriever mmr = mock(MediaMetadataRetriever.class);
        TrackLibraryAction.add("asd", mmr);
    }
}
