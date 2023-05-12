package com.rajan.qfontask.service

import com.myfitness.utils.AppConstants
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(AppConstants.apiEndPoint)
    fun getUserData(
        @Query("page") page : Int, @Query("results") two : Int = 10
    ): Call<ResponseBody>

}