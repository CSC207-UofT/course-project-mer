package com.mer.plamer.usecasesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.UserAction;
import com.mer.plamer.usecases.UserLibraryAction;

import org.junit.Test;

public class UserActionTest {

    @Test(timeout = 50)
    public void testSetuser() {
        UserLibraryAction.add("testuser", "123");
        UserAction ua = new UserAction();
        ua.setUser("testuser");
        assertNotNull(ua.getUser());
        assertFalse(ua.isNull());
        assertFalse(ua.isAdmin());
        assertEquals("testuser", ua.getCurrentName());
        assertEquals("123", ua.getCurrentPassword());
        assertTrue(ua.changePwd("1234"));
        assertFalse(ua.changePwd("1234"));
        assertTrue(ua.changeName("asd"));
        assertFalse(ua.changeName("asd"));
        ua.addPlaylist("asd");
        Playlist pl = new Playlist("123");
        String plid = pl.getId();
        PlaylistLibraryAction.playlistLibrary.add(pl);
        ua.addPlaylist(plid);


    }

}
