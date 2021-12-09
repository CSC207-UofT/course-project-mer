package com.mer.plamer.usecasesTest;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;

import android.media.MediaPlayer;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.TrackLibraryAction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.robolectric.shadows.ShadowMediaPlayer;

@RunWith(MockitoJUnitRunner.class)
public class PlayActionTest {

    @Test
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

    @Test
    public void testMP() {
        MediaPlayer mp = mock(MediaPlayer.class);
        PlayAction.setMediaPlayer(mp);
        PlayAction.prepare();
        assertFalse(PlayAction.isPlaying());
        PlayAction.play();
        PlayAction.pause();
        assertEquals(0,PlayAction.getTrackLength());
        int i = PlayAction.getCurrentPosition();
        assertEquals(i, PlayAction.getCurrentPosition());
        TrackLibrary tl = new TrackLibrary();
        Track t1 = new Track("asd");
        t1.setArtist("Drake");
        t1.setTitle("God");
        tl.add(t1);
        TrackLibraryAction.assignLibrary(tl);
        assertNotNull(PlayAction.getArtist());
        assertNotNull(PlayAction.getTitle());
        assertEquals(0, PlayAction.getTrackLength());
        PlayAction.setPosition(0);
        PlaylistLibrary pll = new PlaylistLibrary();
        Playlist pl1 = new Playlist("test1");
        Playlist pl2 = new Playlist("test2");
        pll.add(pl1);
        pll.add(pl2);
        PlaylistLibraryAction.assignLibrary(pll);
        PlayAction.setCurrentPlaylist("test1");
        PlayAction.next();
        PlayAction.prev();
        PlayAction.end();
    }

}
