package com.example.myfinalproject.repository


import com.example.myfinalproject.db.ArticleDatabase
import com.example.myfinalproject.models.Article
import com.example.myfinalproject.network.NewService

class NewsRepository(
    val db:ArticleDatabase
) {
    suspend fun getNews() =
        NewService.create().news().articles

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)
//
    suspend fun getSavedNews() = db.getArticleDao().getSavedArticles()


    suspend fun getAllNewsTech() =
        NewService.create().techNews().articles

    suspend fun getAllNewsWorldWide() =
        NewService.create().newsWorldWide().articles

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}