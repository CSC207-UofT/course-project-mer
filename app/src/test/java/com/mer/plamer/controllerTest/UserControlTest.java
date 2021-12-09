package com.mer.plamer.controllerTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import com.mer.plamer.TinyDB;
import com.mer.plamer.controller.UserControl;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.UserAction;
import com.mer.plamer.usecases.UserLibraryAction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.mock.*;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserControlTest {

    @Test
    public void testUC() {
        TinyDB tinyDB = mock(TinyDB.class);
        UserControl uc = new UserControl(tinyDB);
        assertTrue(uc.registration("test", "123"));
        uc.login_check("test", "123");
        assertFalse(uc.login_check("123", "321"));
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

    @Test
    public void testAdminUC() {
        TinyDB tinyDB = mock(TinyDB.class);
        UserControl uc = new UserControl(tinyDB);

    }
}
