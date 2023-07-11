package com.example.myfinalproject.db


import com.example.myfinalproject.models.Article
import androidx.room.*

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

   @Query("SELECT * FROM articles")
   suspend fun getSavedArticles(): List<Article>

    @Delete
    suspend fun deleteArticle(article: Article)
}