package com.webtomob.newsapp.utility;

import android.app.Application;

public class App extends Application {
    private static App mInstance;
    public static boolean isDebuggable;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        // Normal app init code...

    }

    public static App getInstance() {
        return mInstance;
    }

}