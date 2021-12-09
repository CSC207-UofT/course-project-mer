package com.mer.plamer;

import android.app.Application;
import android.content.Context;

/**
 * Helper activity to provide context for TinyDB
 */
public class MyApp extends Application {
    private static MyApp instance;

    /**
     * Give requested body the context of this application
     * @return the context of this application
     */
    public static Context getContext() { return instance.getApplicationContext();}

    /**
     * Associate the object to this application
     */
    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
