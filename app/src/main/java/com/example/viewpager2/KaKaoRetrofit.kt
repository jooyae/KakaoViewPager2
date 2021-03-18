package com.example.viewpager2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KaKaoRetrofit {
    @GET("/v2/search/vclip")
    fun getVideoResult(@Header("Authorization") token: String, @Query("query") query: String): Call<ResponseSearchVideo>
}