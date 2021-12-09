package com.mer.plamer.controllerTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mer.plamer.TinyDB;
import com.mer.plamer.controller.AddAdapter;
import com.mer.plamer.controller.UserAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class UserAdapterTest {
    UserAdapter ua;

    @Before
    public void setUp() {
        Context ctx = mock(Context.class);
        LayoutInflater lif = mock(LayoutInflater.class);
        ArrayList<String> testlist = new ArrayList<>();
        testlist.add("name");
        testlist.add("test");
        ua = new UserAdapter(ctx, testlist, lif);
    }

    @Test
    public void testProperties() {
        assertEquals(2, ua.getCount());
        ua.getItem(0);
        assertEquals(0, ua.getItemId(0));
    }
}