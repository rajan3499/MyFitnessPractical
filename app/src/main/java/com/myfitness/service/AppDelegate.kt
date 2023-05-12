package com.myfitness.service

import android.app.Application
import com.rajan.qfontask.service.RetrofitUtils

class AppDelegate : Application() {

    val apiInterface by lazy { RetrofitUtils.callAPI() }

    override fun onCreate() {
        super.onCreate()
    }
}