package com.example.myfinalproject.models

import com.google.gson.annotations.SerializedName

data class NewsRespone(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)