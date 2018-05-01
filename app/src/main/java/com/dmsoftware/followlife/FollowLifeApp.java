package com.dmsoftware.followlife;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class FollowLifeApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
