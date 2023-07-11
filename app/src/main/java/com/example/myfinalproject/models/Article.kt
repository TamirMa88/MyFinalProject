package com.example.myfinalproject.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity(
    tableName = "articles"
)
data class Article(
    @SerializedName("author")
    val author: String,
    @SerializedName("content")
    val content: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("source")
    //@TypeConverters(Converters::class)
    val source: Source,
    @SerializedName("title")
    @PrimaryKey
    val title: String,
    @SerializedName("url")
    val url: String?,
    @SerializedName("urlToImage")
    val urlToImage: String?,
    ): Serializable