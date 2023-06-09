package com.example.myfinalproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfinalproject.db.ArticleDatabase
import kotlinx.coroutines.launch
import com.example.myfinalproject.network.NewService
import com.example.myfinalproject.models.Article
import com.example.myfinalproject.repository.NewsRepository

class HomeViewModel(val newsRepository: NewsRepository) : ViewModel() {

    // val news : List<Article> = NewService.create().techNews().articles

    private val _news: MutableLiveData<List<Article>> = MutableLiveData()
    val news: LiveData<List<Article>> = _news

    init {
        viewModelScope.launch {
            _news.postValue(newsRepository.getNews())
        }
    }
}