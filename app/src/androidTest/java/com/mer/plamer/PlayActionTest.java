//package com.mer.plamer;
//
//import android.content.Context;
//
//import androidx.test.platform.app.InstrumentationRegistry;
//
//import com.mer.plamer.usecases.PlayAction;
//
//import org.junit.Test;
//
///**
// * Example local unit test, which will execute on the development machine (host).
// *
// * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
// */
//public class PlayActionTest {
//
//    public static final int MEDIA_ID = R.raw.oyasumi;
//
//    @Test
//    public void TestPlayActionPlay() {
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        PlayAction player = new PlayAction(appContext.getResources().openRawResourceFd(MEDIA_ID));
//        player.play();
//        assert player.isPlaying();
//    }
//
//    @Test
//    public void TestPlayActionPause() {
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        PlayAction player = new PlayAction(appContext.getResources().openRawResourceFd(MEDIA_ID));
//        player.play();
//        player.pause();
//        assert !player.isPlaying();
//    }
//}