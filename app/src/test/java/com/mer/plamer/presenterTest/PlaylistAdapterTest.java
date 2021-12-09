package com.mer.plamer.presenterTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import android.view.LayoutInflater;

import com.mer.plamer.presenter.PlaylistAdapter;

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
        assertEquals("id1", pla.getItem(0));
        assertEquals(0, pla.getItemId(0));
    }
}
