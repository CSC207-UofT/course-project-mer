package com.mer.plamer.controllerTest;

import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import com.mer.plamer.gateway.TinyDB;
import com.mer.plamer.controller.TrackLibraryControl;
import android.media.MediaMetadataRetriever;

@RunWith(MockitoJUnitRunner.class)
public class TrackLibraryControlTest {

    @Test
    public void testConstructorAddDel() {
        TinyDB tinydb = mock(TinyDB.class);
        TrackLibraryControl tlc = new TrackLibraryControl(tinydb);
        MediaMetadataRetriever mmr = mock(MediaMetadataRetriever.class);
        tlc.add("asd", mmr);
        tlc.remove("asd");
    }

}