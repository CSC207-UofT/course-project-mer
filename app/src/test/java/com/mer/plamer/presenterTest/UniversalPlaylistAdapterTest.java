package com.mer.plamer.presenterTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import android.view.LayoutInflater;

import com.mer.plamer.presenter.UniversalPlaylistAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class UniversalPlaylistAdapterTest {
    UniversalPlaylistAdapter upla;

    @Before
    public void setUp(){
        LayoutInflater lif = mock(LayoutInflater.class);
        ArrayList<String> testlist = new ArrayList<>();
        testlist.add("name");
        testlist.add("test");
        upla = new UniversalPlaylistAdapter(lif, testlist);
    }

    @Test
    public void testProperties() {
        assertEquals(2, upla.getCount());
        assertEquals("name", upla.getItem(0));
        assertEquals(0, upla.getItemId(0));
    }
}