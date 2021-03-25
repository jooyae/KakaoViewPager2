package com.example.viewpager2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitService {
    private val KAKAO_URL = "https://dapi.kakao.com"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(KAKAO_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}