package com.example.myfinalproject.ui

import com.example.myfinalproject.models.Article
import kotlinx.coroutines.Job

interface ViewModelInterface {
    fun saveArticle(article: Article): Job
    fun deleteArticle(article: Article): Job
}