package com.mer.plamer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.mer.plamer.userAction.PlayAction;
import com.mer.plamer.MainActivity;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PlayActionTest {

    public static final int MEDIA_ID = R.raw.oyasumi;

    @Test
    public void TestPlayActionPlay() {
        MainActivity m = new MainActivity();
        Activity a = new m.getApplicationContext();
        PlayAction player = new PlayAction(a.getResources().openRawResourceFd(MEDIA_ID));
        player.play();
        player.pause();
        assert !player.isPlaying();
    }
}