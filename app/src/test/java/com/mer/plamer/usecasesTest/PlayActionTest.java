package com.mer.plamer.usecasesTest;

import org.junit.Test;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.Track;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.TrackLibraryAction;

import static org.mockito.Mockito.mock;

import org.robolectric.shadows.ShadowMediaPlayer;

//@RunWith(RobolectricTestRunner.class)
public class PlayActionTest {

    @Test(timeout = 50)
    public void test1() {
        ShadowMediaPlayer smp = new ShadowMediaPlayer();
        Track t1 = new Track("samplepath");
        String t1id = t1.getID();
        t1.setLength("100");
        t1.setTitle("GOD");
        t1.setArtist("Jcole");
        t1.setGenre("Rap");
        Track t2 = new Track("samplepath2");
        TrackLibraryAction.trackLibrary.add(t1);
        PlayAction.setCurrentTrack(t1id);
        Playlist pl = new Playlist("test");
        pl.addTrack(t1);
        pl.addTrack(t2);
        String plid = pl.getId();
        PlaylistLibraryAction.playlistLibrary.add(pl);
        PlayAction.setCurrentPlaylist(plid);
        PlayAction.shuffle();

    }

}
