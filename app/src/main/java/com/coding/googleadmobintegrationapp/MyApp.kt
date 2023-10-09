package com.coding.googleadmobintegrationapp

import android.app.Application
import com.google.android.gms.ads.MobileAds

class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) {}
    }
}