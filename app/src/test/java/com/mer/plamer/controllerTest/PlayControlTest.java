package com.mer.plamer.controllerTest;

import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

import android.media.MediaPlayer;

import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.TrackLibraryAction;

@RunWith(MockitoJUnitRunner.class)
public class PlayControlTest {

    @Test
    public void testPCActions() {
        MediaPlayer mp = mock(MediaPlayer.class);
        PlayAction.setMediaPlayer(mp);
        PlayControl.playPause();
        assertEquals("Repeat ON", PlayControl.changePlayMode());
        assertEquals("Shuffle", PlayControl.changePlayMode());
        assertEquals("Repeat OFF", PlayControl.changePlayMode());
    }

    @Test
    public void testChanges() {
        MediaPlayer mp = mock(MediaPlayer.class);
        PlayAction.setMediaPlayer(mp);
        PlayControl.next();
        PlayControl.prev();

        TrackLibrary tl = new TrackLibrary();
        Track t1 = new Track("asd");
        t1.setArtist("Drake");
        t1.setTitle("God");
        tl.add(t1);
        TrackLibraryAction.assignLibrary(tl);
        PlayAction.setPosition(0);
        PlaylistLibrary pll = new PlaylistLibrary();
        Playlist pl1 = new Playlist("test1");
        Playlist pl2 = new Playlist("test2");
        pl1.addTrack(t1);
        pll.add(pl1);
        pll.add(pl2);
        PlaylistLibraryAction.assignLibrary(pll);

        String pl1id = pl1.getId();
        String t1id = t1.getID();
        PlayControl.setMedia(pl1id, t1id);

    }

    @Test
    public void testTime() {
        MediaPlayer mp = mock(MediaPlayer.class);
        PlayAction.setMediaPlayer(mp);
        assertEquals(10000, PlayControl.toSeconds(10000000));
        assertEquals("16:40" , PlayControl.toMinuteSeconds(1000000));

    }

}