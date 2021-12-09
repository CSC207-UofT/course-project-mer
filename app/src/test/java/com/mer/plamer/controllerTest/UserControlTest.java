package com.mer.plamer.controllerTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import com.mer.plamer.gateway.TinyDB;
import com.mer.plamer.controller.UserControl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserControlTest {

    @Test
    public void testUC() {
        TinyDB tinyDB = mock(TinyDB.class);
        UserControl uc = new UserControl(tinyDB);
        assertTrue(uc.registration("test", "123"));
        uc.loginCheck("test", "123");
        assertFalse(uc.loginCheck("123", "321"));
        assertNotNull(uc.getAccountInfo());
        uc.registration("asd", "asd");
        assertFalse(uc.userDeletion("asd"));
        uc.removePlaylist("asd");
        uc.modifyUserPassword("asd");
        uc.modifyUserPassword("sdf");

    }

    @Test
    public void testEmptyUC() {
        TinyDB tinyDB = mock(TinyDB.class);
        UserControl uc = new UserControl(tinyDB);
        assertEquals("No user founded.", uc.getAccountInfo());
        uc.scanLocal();

    }
}
