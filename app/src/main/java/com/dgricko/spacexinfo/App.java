package com.dgricko.spacexinfo;

import android.app.Application;

import com.dgricko.spacexinfo.api.SpaceInfoService;

public class App extends Application {
    private SpaceInfoService spaceInfoService;

    @Override
    public void onCreate() {
        super.onCreate();
        spaceInfoService = new SpaceInfoService();
    }

    public SpaceInfoService getSpaceInfoService(){return spaceInfoService;}
}
