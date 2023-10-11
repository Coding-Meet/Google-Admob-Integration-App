package com.coding.googleadmobintegrationapp

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import com.coding.googleadmobintegrationapp.mynative.TemplateView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError


fun loadBannerAds(
    context: Context,
    adsFrameLayout: FrameLayout,
    adSize: AdSize,
    adUnitIdL : Int
){
    val adView = AdView(context)
    adView.setAdSize(adSize)
    adView.adUnitId = context.getString(adUnitIdL)
    adsFrameLayout.addView(adView)

    val adRequest = AdRequest.Builder().build()
    adView.loadAd(adRequest)
    adView.adListener = object : AdListener(){

        override fun onAdFailedToLoad(adError: LoadAdError) {
            super.onAdFailedToLoad(adError)
            adsFrameLayout.gone()
            adView.loadAd(adRequest)
        }

        override fun onAdLoaded() {
            super.onAdLoaded()
            adsFrameLayout.visible()
        }
    }

}

fun loadSmallMediumSizeNativeAds(context: Context,adUnitIdL: Int,templateView: TemplateView){
    val adLoader = AdLoader.Builder(context,context.getString(adUnitIdL))
        .forNativeAd { nativeAd ->
            templateView.visible()
            templateView.setNativeAd(nativeAd)
        }.withAdListener(object :AdListener(){
            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                templateView.gone()
            }
        }).build()
    adLoader.loadAd(AdRequest.Builder().build())
}


fun View.gone(){
    visibility = View.GONE
}
fun View.visible(){
    visibility = View.VISIBLE
}