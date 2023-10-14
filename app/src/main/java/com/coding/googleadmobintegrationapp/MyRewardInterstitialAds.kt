package com.coding.googleadmobintegrationapp

import android.app.Activity
import android.widget.Toast
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback

class MyRewardInterstitialAds(private val activity: Activity) {
    private var rewardInterstitialAds : RewardedInterstitialAd? = null

    fun loadRewardInterstitialAds(adUnitIdL : Int){
        val adRequest = AdRequest.Builder().build()

        RewardedInterstitialAd.load(
            activity,
            activity.getString(adUnitIdL),
            adRequest,
            object : RewardedInterstitialAdLoadCallback(){
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    rewardInterstitialAds = null
                }

                override fun onAdLoaded(mRewardedInterstitialAd: RewardedInterstitialAd) {
                    rewardInterstitialAds = mRewardedInterstitialAd
                }
            }
        )
    }
    fun showRewardedInterstitialAds(
        adUnitIdL: Int, afterCodeRewardCoin: (RewardItem) -> Unit
    ){
        if (rewardInterstitialAds != null){
            rewardInterstitialAds!!.fullScreenContentCallback =
                object : FullScreenContentCallback(){
                    override fun onAdDismissedFullScreenContent() {
                        rewardInterstitialAds = null
                        loadRewardInterstitialAds(adUnitIdL)
                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                        rewardInterstitialAds = null
                    }
                }
            rewardInterstitialAds!!.show(activity){
                afterCodeRewardCoin(it)
            }
        }else{
            Toast.makeText(activity,"Ads is not loaded",Toast.LENGTH_LONG).show()
        }
    }
}