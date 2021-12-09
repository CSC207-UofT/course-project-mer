package com.mer.plamer.controllerTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;

import com.mer.plamer.controller.AddAdapter;
import com.mer.plamer.controller.PlayControl;
import com.mer.plamer.controller.PlaylistAdapter;
import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;
import com.mer.plamer.usecases.PlayAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.TrackLibraryAction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class AddAdapterTest {

    AddAdapter aa;

    @Before
    public void setUp() {
        Context ctx = mock(Context.class);
        LayoutInflater lif = mock(LayoutInflater.class);
        ArrayList<AddAdapter.AddDataHolder> testlist = new ArrayList<>();
        AddAdapter.AddDataHolder ah = mock(AddAdapter.AddDataHolder.class);
        testlist.add(ah);
        aa = new AddAdapter(ctx, testlist, lif);
    }

    @Test
    public void testProperties() {
        assertEquals(1, aa.getCount());
        assertNotNull(aa.getItem(0));
        assertEquals(0, aa.getItemId(0));

        MediaPlayer mp = mock(MediaPlayer.class);
        PlayAction.setMediaPlayer(mp);
        PlayControl.next();
        PlayControl.prev();

        TrackLibrary tl = new TrackLibrary();
        Track t1 = new Track("asd");
        t1.setArtist("Drake");
        t1.setTitle("God");
        t1.setLength("100");
        tl.add(t1);
        String t1id = t1.getID();
        TrackLibraryAction.assignLibrary(tl);
        PlayAction.setPosition(0);
        PlaylistLibrary pll = new PlaylistLibrary();
        Playlist pl1 = new Playlist("test1");
        Playlist pl2 = new Playlist("test2");
        pl1.addTrack(t1);
        pll.add(pl1);
        pll.add(pl2);
        PlaylistLibraryAction.assignLibrary(pll);

        AddAdapter.AddDataHolder aah = new AddAdapter.AddDataHolder(t1id, true);
    }
}