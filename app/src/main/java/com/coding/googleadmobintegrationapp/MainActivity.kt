package com.coding.googleadmobintegrationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.gms.ads.AdSize

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adsFrameLayout = findViewById<FrameLayout>(R.id.adsFrameLayout)

//        AdSize.BANNER
        loadBannerAds(this,adsFrameLayout, AdSize.BANNER,R.string.banner_ads1)

//        AdSize.LARGE_BANNER
//        loadBannerAds(this,adsFrameLayout, AdSize.LARGE_BANNER,R.string.banner_ads1)

//        AdSize.FULL_BANNER
//        loadBannerAds(this,adsFrameLayout, AdSize.FULL_BANNER,R.string.banner_ads1)
    }
}