package com.example.myfinalproject.network

import com.example.myfinalproject.models.NewsRespone
import com.example.myfinalproject.utils.TokenNewsInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import retrofit2.http.GET


interface NewService {

    @GET("v2/top-headlines?country=il&category=technology")
    suspend fun techNews(): NewsRespone


    companion object {
        private const val BASE_URL = "https://newsapi.org/"
        fun create(): NewService {
            val client = OkHttpClient.Builder()
                .addInterceptor(TokenNewsInterceptor())
                .build()


            return Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(NewService::class.java)
        }
    }
}