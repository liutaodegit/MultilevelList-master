package com.example.frame;

import android.app.Application;
import android.content.Context;


public class FrameApplication extends Application {
    private static FrameApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static FrameApplication getFrameApplication() {
        return application;
    }

    public static Context getFrameApplicationContext() {
        return application.getApplicationContext();
    }
}
