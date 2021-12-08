package com.mer.plamer.controllerTest;

import com.mer.plamer.TinyDB;
import com.mer.plamer.controller.UserControl;
import com.mer.plamer.entities.User;
import com.mer.plamer.usecases.UserAction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserControlTest {

    @Mock
    public User u;
    public UserAction ua;
    public UserControl uc;
    public TinyDB mockedTinydb;

    @Before
    public void setUp() {
        u = new User("test", "test123");
        ua = new UserAction();
//        ua.setUser(u);
//        uc = new UserControl(mockedTinydb);
    }

    @Test
    public void test1() {

//        assertTrue(when(uc.registration("test", "test12")));
    }
}
