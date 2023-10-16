package com.coding.googleadmobintegrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
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



        val sharedPreferenceManger = SharedPreferenceManger(this)
        getRewardedCoin(sharedPreferenceManger.totalRewardedAmount)

        val rewardedAdsBtn = findViewById<Button>(R.id.rewardedAdsBtn)
        val myRewardedAds = MyRewardedAds(this)
        myRewardedAds.loadRewardedAds(R.string.rewarded_ads1)

        rewardedAdsBtn.setOnClickListener {
            myRewardedAds.showRewardedAds(R.string.rewarded_ads1){
                val rewardedCoin = it.amount
                sharedPreferenceManger.totalRewardedAmount += rewardedCoin
                getRewardedCoin(sharedPreferenceManger.totalRewardedAmount)
            }
        }

        val rewardedInterstitialAdsBtn = findViewById<Button>(R.id.rewardedInterstitialAdsBtn)

        val rewardInterstitialAds = MyRewardInterstitialAds(this)
        rewardInterstitialAds.loadRewardInterstitialAds(R.string.rewardInterstitialAds)

        rewardedInterstitialAdsBtn.setOnClickListener {
            rewardInterstitialAds.showRewardedInterstitialAds(R.string.rewardInterstitialAds) {
                val rewardedCoin = it.amount
                sharedPreferenceManger.totalRewardedAmount += rewardedCoin
                getRewardedCoin(sharedPreferenceManger.totalRewardedAmount)
            }
        }



        val showAdsRVBtn = findViewById<Button>(R.id.showAdsRVBtn)
        showAdsRVBtn.setOnClickListener {
            val showAdsRecyclerIntent = Intent(this,ShowAdsRVActivity::class.java)
            startActivity(showAdsRecyclerIntent)
        }
    }

    private fun getRewardedCoin(totalRewardedAmount: Int){
        val totalRATxt = findViewById<TextView>(R.id.totalRATxt)
        totalRATxt.text = "Total Rewarded Coins: $totalRewardedAmount Coins"
    }
}