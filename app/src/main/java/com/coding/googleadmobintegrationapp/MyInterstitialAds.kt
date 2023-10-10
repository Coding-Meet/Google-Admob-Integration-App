package com.coding.googleadmobintegrationapp

import android.app.Activity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MyInterstitialAds(private val activity: Activity) {

    private var interstitialAds : InterstitialAd? = null


    fun loadInterstitialAds(adUnitId: Int){
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            activity,
            activity.getString(adUnitId),
            adRequest,
            object : InterstitialAdLoadCallback(){
                override fun onAdLoaded(mInterstitialAds: InterstitialAd) {
                    interstitialAds = mInterstitialAds
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    interstitialAds = null
                }
            }
        )
    }
    fun showInterstitialAds(afterSomeCode : () -> Unit){
        if (interstitialAds != null){
            interstitialAds!!.fullScreenContentCallback =
                object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        interstitialAds = null
                        afterSomeCode()
                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                        interstitialAds = null
                        afterSomeCode()
                    }

                }

            interstitialAds!!.show(activity)
        }else{
            afterSomeCode()
        }
    }

}