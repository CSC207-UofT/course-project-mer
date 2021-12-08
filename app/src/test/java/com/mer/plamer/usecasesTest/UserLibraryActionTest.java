package com.mer.plamer.usecasesTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.ArrayList;
import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.User;
import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.UserLibrary;
import com.mer.plamer.usecases.UserLibraryAction;

public class UserLibraryActionTest {

    @Test(timeout = 50)
    public void testAdd() {
        UserLibraryAction.add("testuser", "123");
        assertNotNull(UserLibraryAction.search("testuser"));
        assertTrue(UserLibraryAction.userRegister("testuser2", "321"));
        assertFalse(UserLibraryAction.userRegister("testuser2", "321"));
        assertFalse(UserLibraryAction.userRegister("", "321"));
        assertTrue(UserLibraryAction.userLogin("testuser2", "321"));
        assertFalse(UserLibraryAction.userLogin("testuser2", "31"));
        assertNotNull(UserLibraryAction.getAllUserName());
        UserLibraryAction.delete("testuser");
        UserLibrary nul = new UserLibrary();
        UserLibraryAction.assignLibrary(nul);
    }

}
