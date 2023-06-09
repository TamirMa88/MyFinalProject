package com.example.myfinalproject.utils

import okhttp3.Interceptor
import okhttp3.Response

class TokenNewsInterceptor () : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val original =
            chain.request()

        val url = original.url().newBuilder()
            .addQueryParameter("apiKey", "a07bbbed5d38422ba073d7848166e3a8")
            .build()

        //val url1=original.url.newBu

        val request = original.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}