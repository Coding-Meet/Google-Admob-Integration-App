package com.coding.googleadmobintegrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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




        val showInterstitialAdsBtn = findViewById<Button>(R.id.showInterstitialAdsBtn)

        val myInterstitialAds = MyInterstitialAds(this)
        myInterstitialAds.loadInterstitialAds(R.string.interstitial_ads1)

        showInterstitialAdsBtn.setOnClickListener {
            myInterstitialAds.showInterstitialAds {

                // here interstitial finish or dismiss or not load after execute
                val afterIntent = Intent(this,AfterInterstitalFinishedActivity::class.java)
                startActivity(afterIntent)

            }
        }




        val showSmallMediumNativeAdsBtn = findViewById<Button>(R.id.showSmallMediumNativeAdsBtn)
        showSmallMediumNativeAdsBtn.setOnClickListener {

            val smallMediumIntent = Intent(this,SmallMediumNativeAdsActivity::class.java)
            startActivity(smallMediumIntent)
        }

    }
}