package com.mer.plamer.controllerTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;

import com.mer.plamer.controller.PlaylistAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;


@RunWith(MockitoJUnitRunner.class)
public class PlaylistAdapterTest {

    PlaylistAdapter pla;

    @Before
    public void setUp() {
        LayoutInflater lif = mock(LayoutInflater.class);
        ArrayList<String> plid = new ArrayList<>();
        plid.add("id1");
        plid.add("id2");
        pla = new PlaylistAdapter(lif, plid);
    }

    @Test
    public void testProperties() {
        assertEquals(2, pla.getCount());
        assertNull(pla.getItem(0));
        assertEquals(0, pla.getItemId(0));
    }
}
