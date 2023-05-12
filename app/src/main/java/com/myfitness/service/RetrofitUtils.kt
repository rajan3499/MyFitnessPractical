package com.rajan.qfontask.service

import com.myfitness.utils.AppConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitUtils {

    fun callAPI(): ApiInterface {

        val retrofit = Retrofit.Builder().baseUrl(AppConstants.baseUrl).client(
            OkHttpClient.Builder().readTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(100, TimeUnit.SECONDS).build()
        ).addConverterFactory(GsonConverterFactory.create()).build()

        return retrofit.create(ApiInterface::class.java)
    }
}