package com.mer.plamer.usecasesTest;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;
import com.mer.plamer.usecases.TrackLibraryAction;
import java.util.ArrayList;

public class TrackLibraryActionTest {

    @Test(timeout = 50)
    public void testActions() {
        Track t1 = new Track("samplepath");
        t1.setArtist("Jcole");
        String t1id = t1.getID();
//        TrackLibraryAction.add(t1);
        assertTrue(TrackLibraryAction.delete(t1id));
        assertFalse(TrackLibraryAction.delete("103"));
        assertNotNull(TrackLibraryAction.search("cole"));
        TrackLibrary tl = new TrackLibrary();
        TrackLibraryAction.assignLibrary(tl);
        TrackLibraryAction.emptyTheLibrary();
    }

}
