package com.coding.googleadmobintegrationapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity


class SharedPreferenceManger(context: Context) {
    private val preference = context.getSharedPreferences(
        context.packageName,
        AppCompatActivity.MODE_PRIVATE
    )
    private val editor = preference.edit()


    private val keyTotalRewardedAmount = "totalRewardedAmount"


    var totalRewardedAmount
        get() = preference.getInt(keyTotalRewardedAmount, 0)
        set(value) {
            editor.putInt(keyTotalRewardedAmount, value)
            editor.commit()
        }

}