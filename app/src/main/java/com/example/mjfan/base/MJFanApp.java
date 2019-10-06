package com.example.mjfan.base;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

public class MJFanApp extends Application {
    private static WeakReference<MJFanApp> instance = new WeakReference<>(null);

    public static Context getContext() {
        return instance.get().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance.clear();
        instance = new WeakReference<>(this);
    }
}