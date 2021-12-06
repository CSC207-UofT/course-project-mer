package com.mer.plamer.usecasesTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.ArrayList;
import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.Track;
import com.mer.plamer.usecases.UserLibraryAction;

public class UserLibraryActionTest {

    @Test(timeout = 50)
    public void testAdd() {
        UserLibraryAction ula = new UserLibraryAction();
        User u = new User("test", "test123");
        ula.add("test", "test123");
        assertEquals(u, ula.search("test").get(0));
    }

    @Test(timeout = 50)
    public void testDelete() {
        UserLibraryAction ula = new UserLibraryAction();
        ula.add("test", "test123");
        ula.delete("test");
    }

    @Test(timeout = 50)
    public void testUserRegister() {
        UserLibraryAction ula = new UserLibraryAction();
        User u = new User("test", "test123");
        ula.add("test", "test123");
        assertNull(ula.userRegister("test", "test123"));
        assertNotNull(ula.userRegister("lebum", "james"));
    }

    @Test(timeout = 50)
    public void testUserLogin() {
        UserLibraryAction ula = new UserLibraryAction();
        User u = new User("test", "test123");
        ula.add("test", "test123");
        assertTrue(ula.userLogin("test", "test123"));
        assertFalse(ula.userLogin("123", "321"));
    }
}
