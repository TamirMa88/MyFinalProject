package com.example.myfinalproject.repository

import com.example.myfinalproject.db.ArticleDatabase
import com.example.myfinalproject.models.Article
import com.example.myfinalproject.network.NewService

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getNews() =
        NewService.create().techNews().articles

//    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)
//
//    fun getSavedNews() = db.getArticleDao().getAllArticles()

}