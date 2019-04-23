package com.girish.restaurants;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class RestaurantsApplication extends Application {

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
